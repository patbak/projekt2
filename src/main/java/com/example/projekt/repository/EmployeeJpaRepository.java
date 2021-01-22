package com.example.projekt.repository;

import com.example.projekt.model.Employee;
import com.example.projekt.model.Hours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "pracownicy", collectionResourceRel = "pracownicy")
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {


}
