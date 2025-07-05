package com.ApiCreation.Haardik.ApiCreation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//in this class we will define the data transfer object for Employee
//all the data about the employee than we want to transfer from one layer to another

@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields(constructor in which all the fields are passed)
@NoArgsConstructor // Lombok annotation to generate a default constructor (no-args constructor)
public class EmployeeDTO {
    private Long id;
    private String name;
    private LocalDate date;
    @JsonProperty("is_active") // This annotation is used to map the JSON property "is_active" to the field "isActive"
    private boolean isActive;
}
