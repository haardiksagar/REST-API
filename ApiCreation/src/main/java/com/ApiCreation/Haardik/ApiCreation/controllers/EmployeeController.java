package com.ApiCreation.Haardik.ApiCreation.controllers;

import com.ApiCreation.Haardik.ApiCreation.dto.EmployeeDTO;
import com.ApiCreation.Haardik.ApiCreation.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    //Presentation(DTO) <---> Service(Entity) <---> Persistence/Database/Repository
    //Therefore Service will only use the Repository object and Controller will use the Service object.
    //vice versa not alowed
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Two ways to input data : PathVariable and PathParam and there is one more way
    // which is RequestBody(for inputting Objects)
    @GetMapping(path="/{id}")//don't leave space b/w GetMapping and (.....)
    public EmployeeDTO getEmployeeById(@PathVariable("id") Long empID) {
        return employeeService.getEmployeeById(empID);
    }

    @GetMapping(path="/data")//http://localhost:8080/employees/data?sortBy=age&limit=4
    public String getdata(@PathParam("sortBy") String sortBy,
                          @PathParam("limit") Integer limit) {
        return "Hello World " + sortBy + limit;
    }

    @GetMapping
    public List<EmployeeDTO> ListOfEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping()
    //@RequestBody is used to bind the body of an HTTP request to a method parameter in a
    // controller handler method.
    //When there is a a request for a object like EmployeeDTO, we use @RequestBody to get that object
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        //Here you can call the service method to save the employeeDTO
        //and return the saved employeeDTO
        //For now, we will just return the same employeeDTO
        return employeeService.createNewEmployee(employeeDTO);
    }

    //This DB is volatile hence add the data first and then try to delete it
    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployee(@PathVariable("id") Long id) {
        return employeeService.deleteEmployee(id);
    }
}
