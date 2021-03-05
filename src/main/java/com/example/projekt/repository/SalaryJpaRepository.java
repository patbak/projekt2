package com.example.projekt.repository;

import com.example.projekt.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface SalaryJpaRepository extends JpaRepository<Salary, Integer> {

    List<Salary> findAllByDate(LocalDate date);
    List<Salary> findAllByDateBetween(LocalDate startOfMont, LocalDate endOfMonth);

}
