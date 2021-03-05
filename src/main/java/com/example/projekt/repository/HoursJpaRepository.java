package com.example.projekt.repository;

import com.example.projekt.model.Hours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HoursJpaRepository extends JpaRepository<Hours,Integer> {

    List<Hours> findAllByDateBetween(LocalDate startOfMonth, LocalDate endOfMonth);

    List<Hours> findAllByDateBetweenAndAndEmployee_EmployeeId(LocalDate startOfMonth, LocalDate endOfMonth, int id);

    List<Hours> findAllByDateBetweenAndConstructionSite_ConstructionSiteId(LocalDate startOfMonth, LocalDate endOfMonth, int id);
}
