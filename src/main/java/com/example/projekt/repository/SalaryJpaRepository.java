package com.example.projekt.repository;

import com.example.projekt.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryJpaRepository extends JpaRepository<Salary, Integer> {



}
