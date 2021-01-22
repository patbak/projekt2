package com.example.projekt.service;

//import com.example.projekt.entity.LocalDateConverter;
import com.example.projekt.model.Timesheet;
import com.example.projekt.repository.TimesheetJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class TimesheetService {

    @Autowired
    private TimesheetJpaRepository timesheetJpaRepository;


    public List<Timesheet> getLastMonthTimesheets( int id){
        LocalDate localDate = LocalDate.now();
        LocalDate lastMonth = localDate.minusMonths(1);

        LocalDate startOfMonth = LocalDate.of(lastMonth.getYear(), lastMonth.getMonth(), 1);
        LocalDate endOfMonth = LocalDate.of(lastMonth.getYear(), lastMonth.getMonth(), lastMonth.lengthOfMonth());

        List<Timesheet> timesheets = timesheetJpaRepository.findAllByTimesheetDateBetweenAndEmployee_EmployeeId(
                startOfMonth,
                endOfMonth,
                id);

        return timesheets;
    }


}
