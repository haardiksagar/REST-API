package com.ApiCreation.Haardik.ApiCreation.services;

import com.ApiCreation.Haardik.ApiCreation.Repositories.EmployeeRepo;
import com.ApiCreation.Haardik.ApiCreation.dto.EmployeeDTO;
import com.ApiCreation.Haardik.ApiCreation.entities.EmployeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    final EmployeeRepo employeeRepo;
    final ModelMapper modelMapper;    //for the entity to DTO conversion and vice versa

    //dependency injection through constructor
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
        this.modelMapper = new ModelMapper(); // Initialize ModelMapper
    }

    //Presentation(DTO) <---> Service(Entity) <---> Persistence/Database/Repository
    //Therefore Service will only use the Repository object and Controller will use the Service object.

    // this getEmployeeById will be used in the EmployeeController
    public EmployeeDTO getEmployeeById(Long id){
        //This will return an EmployeeEntity object
        EmployeeEntity employeeEntity = employeeRepo.getById(id);

        //Now we will convert this EmployeeEntity object to EmployeeDTO object
//        return new EmployeeDTO(employeeEntity.getId(),
//                employeeEntity.getName(),
//                employeeEntity.getDate(),
//                employeeEntity.isActive());
        // instead of writing the above code, you can use a mapper library like MapStruct or
        // ModelMapper to convert the entity to DTO

        //since conversion is from persistence to service to controller hence Enity to DTO conversion
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    //Takes the input from the controller which is in EmployeeDTO format then create a new EmployeeEntity object
    //After that its will send a response back to the controller in EmployeeDTO format thats why return
    // type is EmployeeDTO
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO){
        //we need to convert EmployeeDTO to EmployeeEntity for saving it to the database
        //so instead of doing this conversion Entity to DTO and DTO to Entity manually, we will
        //use a mapper library like MapStruct or ModelMapper to do this conversion automatically
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        // now use this model mapped employeeEntity to save it to the database
        return modelMapper.map(employeeRepo.save(employeeEntity), EmployeeDTO.class);
        //this will return the saved EmployeeEntity object in EmployeeDTO format
    }

    public List<EmployeeDTO> getAllEmployees(){
        return employeeRepo
                .findAll()
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public boolean deleteEmployee(Long id){
        boolean isPresent = employeeRepo.existsById(id);
        if(!isPresent) return false;
        employeeRepo.deleteById(id);
        return true;
    }
}
