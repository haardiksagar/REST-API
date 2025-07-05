# Employee Management REST API

A comprehensive Spring Boot REST API for managing employee data with layered architecture, supporting both development and production environments.

## 🚀 Features

- **CRUD Operations**: Create, Read, Update, and Delete employee records
- **Layered Architecture**: Clean separation of concerns with Controller, Service, Repository, and Entity layers
- **DTO Pattern**: Data Transfer Objects for API communication
- **Environment Configuration**: Support for development and production environments
- **Database Integration**: MySQL database with JPA/Hibernate
- **Model Mapping**: Automatic entity-DTO conversion using ModelMapper

## 🛠️ Technology Stack

- **Java 23**
- **Spring Boot 3.5.0**
- **Spring Data JPA**
- **MySQL Database**
- **H2 Database** (for development)
- **Lombok** (for reducing boilerplate code)
- **ModelMapper** (for object mapping)
- **Maven** (build tool)


## 📋 Prerequisites

Before running this application, make sure you have the following installed:

- Java 23 or higher
- Maven 3.6+
- MySQL 8.0+


## 🏗️ Project Architecture

The project follows a layered architecture pattern:

```
Controller Layer (REST API) ←→ Service Layer (Business Logic) ←→ Repository Layer (Data Access) ←→ Database
```

### Layer Responsibilities:

1. **Controller Layer** (`EmployeeController`): Handles HTTP requests and responses
2. **Service Layer** (`EmployeeService`): Contains business logic and orchestrates operations
3. **Repository Layer** (`EmployeeRepo`): Manages data persistence and database operations
4. **Entity Layer** (`EmployeeEntity`): Represents database tables
5. **DTO Layer** (`EmployeeDTO`): Data Transfer Objects for API communication

## 📁 Project Structure

```
src/main/java/com/ApiCreation/Haardik/ApiCreation/
├── ApiCreationApplication.java          # Main application class
├── configuration/
│   └── AppConfig.java                   # Configuration beans
├── controllers/
│   └── EmployeeController.java          # REST API endpoints
├── dto/
│   └── EmployeeDTO.java                 # Data Transfer Object
├── entities/
│   └── EmployeeEntity.java              # JPA Entity
├── Repositories/
│   └── EmployeeRepo.java                # Data access layer
├── services/
│   └── EmployeeService.java             # Business logic layer
├── DB.java                              # Database interface
├── DevDB.java                           # Development database implementation
└── ProdDB.java                          # Production database implementation
```

## ⚙️ Configuration

### Application Properties

The application supports different environments through configuration:

```properties
# Application name
spring.application.name=ApiCreation

# Environment mode (development/production)
project.mode=production

# Database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/newdb
spring.datasource.username=root
spring.datasource.password=Haar4110@

# JPA/Hibernate configuration
spring.jpa.show-sql=true
spring.jpa.generate.ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# H2 Console (for development)
spring.h2.console.enabled=true
```

### Environment-Specific Beans

The application uses conditional beans based on the `project.mode` property:

- **Development Mode**: Uses `DevDB` implementation
- **Production Mode**: Uses `ProdDB` implementation

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd ApiCreation
```

### 2. Database Setup

#### MySQL Setup
1. Create a MySQL database named `newdb`
2. Update database credentials in `application.properties` if needed

#### H2 Database (Development)
- H2 console is enabled and accessible at: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave empty)

### 3. Build the Project

```bash
mvn clean install
```

### 4. Run the Application

#### Using Maven
```bash
mvn spring-boot:run
```

#### Using JAR
```bash
java -jar target/ApiCreation-0.0.1-SNAPSHOT.jar
```



The application will start on `http://localhost:8080`

## 📚 API Documentation

### Base URL
```
http://localhost:8080/employees
```

### API Endpoints

| Method | URL | Description | Sample Valid Request Body |
|--------|-----|-------------|---------------------------|
| GET | `/employees` | Get all employees | - |
| GET | `/employees/{id}` | Get employee by ID | - |
| POST | `/employees` | Create new employee | [JSON](#employeecreate) |
| DELETE | `/employees/{id}` | Delete employee by ID | - |
| GET | `/employees/data` | Get data with query parameters | - |

### Detailed Endpoint Documentation

#### 1. Get All Employees
```http
GET /employees
```

**Response:**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "date": "2023-01-15",
    "is_active": true
  }
]
```

#### 2. Get Employee by ID
```http
GET /employees/{id}
```

**Parameters:**
- `id` (path): Employee ID

**Response:**
```json
{
  "id": 1,
  "name": "John Doe",
  "date": "2023-01-15",
  "is_active": true
}
```

#### 3. Create New Employee
```http
POST /employees
```

**Request Body:**
```json
{
  "name": "Jane Smith",
  "date": "2023-02-20",
  "is_active": true
}
```

**Response:**
```json
{
  "id": 2,
  "name": "Jane Smith",
  "date": "2023-02-20",
  "is_active": true
}
```

#### 4. Delete Employee
```http
DELETE /employees/{id}
```

**Parameters:**
- `id` (path): Employee ID

**Response:**
```json
true
```

#### 5. Get Data with Query Parameters
```http
GET /employees/data?sortBy=age&limit=4
```

**Query Parameters:**
- `sortBy`: Field to sort by
- `limit`: Number of records to return

**Response:**
```
Hello World age4
```

## Sample Valid JSON Request Bodies

##### <a id="employeecreate">Create Employee -> /api/employees</a>
```json
{
    "name": "Andrew Johnson",
    "date": "2023-02-12",
    "is_active": true
}
```

##### <a id="employeeupdate">Update Employee -> /api/employees/{id}</a>
```json
{
    "name": "Andrew Johnson Updated",
    "date": "2023-03-15",
    "is_active": false
}
```

## 🔧 Data Models

### EmployeeDTO
```java
{
  "id": Long,           // Employee ID (auto-generated)
  "name": String,       // Employee name
  "date": LocalDate,    // Joining date
  "is_active": boolean  // Active status
}
```

### EmployeeEntity
```java
{
  "id": Long,           // Primary key
  "name": String,       // Employee name
  "joining_date": LocalDate,  // Joining date
  "is_active": boolean  // Active status
}
```

## 🧪 Testing

### Run Tests
```bash
mvn test
```

### Test Coverage
The project includes unit tests for the main application class.



## 🔍 Key Features Explained

### 1. Layered Architecture
- **Separation of Concerns**: Each layer has a specific responsibility
- **Maintainability**: Easy to modify and extend functionality
- **Testability**: Each layer can be tested independently

### 2. DTO Pattern
- **Data Transfer**: Clean data transfer between layers
- **API Contract**: Stable API interface
- **Security**: Control over what data is exposed

### 3. ModelMapper Integration
- **Automatic Mapping**: Converts between Entity and DTO objects
- **Reduced Boilerplate**: Eliminates manual mapping code
- **Type Safety**: Maintains type safety during conversions

### 4. Environment Configuration
- **Conditional Beans**: Different implementations for different environments
- **Property-Based**: Easy environment switching
- **Flexible**: Easy to add new environments

## 🚨 Error Handling

The API includes basic error handling:
- **404 Not Found**: When employee ID doesn't exist
- **400 Bad Request**: For invalid request data
- **500 Internal Server Error**: For server-side errors

## 📝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License.

## 👨‍💻 Author

**Haardik** - *Initial work*

## 🤝 Support

For support and questions, please open an issue in the repository.

---

**Note**: This is a demo project for Spring Boot showcasing best practices in REST API development with layered architecture and proper separation of concerns. 
