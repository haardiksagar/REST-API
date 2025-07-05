package com.ApiCreation.Haardik.ApiCreation.Repositories;

import com.ApiCreation.Haardik.ApiCreation.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //This annotation will let include Save, FindAll, FindById, DeleteById, and other methods in the EmployeeRepo interface itself
//you don't have to write the queries for these methods.
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Long> {
}
//Persistence layer is just this one line
// but if you want to write custom queries, you can write them in this interface using @Query