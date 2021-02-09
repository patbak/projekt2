package com.example.projekt.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BrigadeDailyReportServiceTest {

    @Autowired
    private BrigadeDailyReportService brigadeDailyReportService;

    @Test
    public void testBuildingService(){

        brigadeDailyReportService.getBrigadeReports();
    }

}
