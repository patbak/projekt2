package com.example.projekt.model;


import com.example.projekt.repository.TimesheetJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class TimesheetTest {

    @Autowired
    private TimesheetJpaRepository repository;

    @Test
    @Transactional
    public void getSalaryTest()throws Exception{
        List<Timesheet> timesheets = repository.findAll();

        for(Timesheet timesheet: timesheets){
            Employee employee = timesheet.getEmployee();
            System.out.println(
                    timesheet.getTimesheetDate()+" "+timesheet.getStartTimeOfWork()+" "
                    +timesheet.getEndTimeOfWork()+" "+timesheet.getHarmfulHours()+" "
                    +employee.getEmployeeName()+" "+employee.getEmployeeLastName()
            );
        }
    }

    }
