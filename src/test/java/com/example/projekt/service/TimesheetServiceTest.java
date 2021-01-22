package com.example.projekt.service;

import com.example.projekt.model.Timesheet;
import com.example.projekt.service.TimesheetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TimesheetServiceTest {

@Autowired
private TimesheetService timesheetService;

    @Test
    public void testFindLastMonthTimesheets(){
        List<Timesheet> timesheets = timesheetService.getLastMonthTimesheets(2);

        for (int i=0; i<timesheets.size();i++){
            System.out.println(timesheets.get(i).getTimesheetDate());
            System.out.println(timesheets.get(i).getStartTimeOfWork());
            System.out.println(timesheets.get(i).getEndTimeOfWork());
            System.out.println(timesheets.get(i).getHarmfulHours());
        }
    }
}
