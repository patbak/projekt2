package com.example.projekt.service;

import com.example.projekt.service.TimesheetService;
import com.example.projekt.service.WorktimeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WorktimeServiceTest {


    @Autowired
    private WorktimeService worktimeService;

    @Test
    public void testCountHours(){


      worktimeService.getTimesheetsToCount();
    }


}
