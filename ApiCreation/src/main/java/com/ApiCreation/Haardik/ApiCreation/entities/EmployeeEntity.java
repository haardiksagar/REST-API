package com.ApiCreation.Haardik.ApiCreation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//persistence is bascially means a database
@Entity //this annotation is used to tell that this class is an entity and it will be mapped to a database table
@Table(name = "employee")//this annotation is used to tell that "this" class is mapped to the "employee" table in the database
//All the anotation used in the EmployeeDTO class are used in this class as well
//all this is lombok annotation
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
    //We copy the fields from EmployeeDTO to EmployeeEntity because the same data will be stored in the database
    @Id//this annotation is used to tell that this field is the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)// and it will be generated automatically
    @Column(name="id")
    private Long id;// this is the primary key and will be generated automatically by the database bc of "@GeneratedValue"
    @Column(name="name")
    private String name;
    @Column(name="joining_date")
    private LocalDate date;
    @Column(name="is_active")
    private boolean isActive;
}
