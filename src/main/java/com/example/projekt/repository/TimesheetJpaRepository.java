package com.example.projekt.repository;

import com.example.projekt.model.Timesheet;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
@RepositoryRestResource(path = "workCards", collectionResourceRel = "workCards")
public interface TimesheetJpaRepository extends JpaRepository<Timesheet, Integer> {

  //  List<Timesheet> findByReportDateAndEmployee_EmployeeId(Date date, int id);

    List<Timesheet> findAllByTimesheetDateBetweenAndEmployee_EmployeeId(
            LocalDate startOfMonth,
            LocalDate endOfMouth,
            int id
    );

    List<Timesheet> findAllByTimesheetDateBetween(LocalDate startOfMonth, LocalDate endOfMonth);
}
