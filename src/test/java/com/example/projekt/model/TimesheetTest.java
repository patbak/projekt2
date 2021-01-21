package com.example.projekt.model;


import com.example.projekt.repository.TimesheetJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TimesheetTest {

    @Autowired
    private TimesheetJpaRepository timesheetJpaRepository;

    @Test
    public void testFindAll(){
       List<Timesheet> timesheets = timesheetJpaRepository.findAll();

        assertTrue(timesheets.size()>0);

        Timesheet timesheet = timesheets.get(0);

        Employee employee = timesheet.getEmployee();

        DailyWorkReport dailyWorkReport = timesheet.getDailyWorkReport();

        System.out.println("\nKarta pracy numer: " + timesheet.getTimesheetId()
                            +" data karty pracy: " + dailyWorkReport.getReportDate()
                            +" pracownik:  " + employee.getEmployeeName() + " "
                            +employee.getEmployeeLastName()
                            +" godzina rozpoczęcia pracy: " + timesheet.getStartTimeOfWork()
                            +" godzina zakończenia pracy: " + timesheet.getEndTimeOfWork() +"\n" );

    }

    @Test
    public void testTimesheetTime(){
        LocalDate datetest = LocalDate.parse("2020-12-20");
        LocalDate startOfMonth = datetest.withDayOfMonth(1);
        LocalDate endOfMonth = datetest.withDayOfMonth(datetest.lengthOfMonth());
     /*   System.out.println(datetest);
        System.out.println(startOfMonth);
        System.out.println(endOfMonth);*/


    List<Timesheet> timesheets = timesheetJpaRepository.findAllByTimesheetDateBetweenAndEmployee_EmployeeId(startOfMonth,endOfMonth, 2);
    for (int i=0; i<timesheets.size();i++){
        System.out.println(timesheets.get(i).getTimesheetDate());
        System.out.println(timesheets.get(i).getStartTimeOfWork());
        System.out.println(timesheets.get(i).getEndTimeOfWork());
        System.out.println(timesheets.get(i).getHarmfulHours());
    }
    }


}
