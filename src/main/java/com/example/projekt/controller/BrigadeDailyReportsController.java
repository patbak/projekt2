package com.example.projekt.controller;

import com.example.projekt.entity.BrigadeDailyReportDto;
import com.example.projekt.entity.BuildingDto;
import com.example.projekt.service.BrigadeDailyReportService;
import com.example.projekt.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrigadeDailyReportsController {

    @Autowired
    private BrigadeDailyReportService brigadeDailyReportService;

    @GetMapping("/BrigadeDailyReports")
    public List<BrigadeDailyReportDto> getReports(){

        List<BrigadeDailyReportDto> brigadeReports = brigadeDailyReportService.getBrigadeReports();
        return brigadeReports;
    }

}
