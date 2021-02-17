package com.example.projekt.controller;

import com.example.projekt.entity.*;
import com.example.projekt.service.BrigadeDailyReportService;
import com.example.projekt.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BrigadeDailyReportsController {

    @Autowired
    private BrigadeDailyReportService brigadeDailyReportService;

    @GetMapping("/brigade-daily-reports")
    public List<BrigadeDailyReportDto> getReports(){


        return brigadeDailyReportService.getBrigadeReports();
    }

    @GetMapping("/brigade-daily-report/{id}")
    public BrigadeDailyReportDto getReportById(@PathVariable int id){

        return brigadeDailyReportService.getBrigadeReportById(id);
    }

    @GetMapping("/brigade-daily-report/{id}/work-cards")
    public List<WorkCardDto> getReportsWorkCardsByReportId(@PathVariable int id){
        return brigadeDailyReportService.getReportsWorkCards(id);
    }

    @GetMapping("/brigade-daily-report/{id}/done-works")
    public List<DoneWorkDto> getReportsDoneWorksByReportId(@PathVariable int id){
        return brigadeDailyReportService.getReportsDoneWorks(id);
    }

    @GetMapping("/brigade-daily-report/{id}/materials-used")
    public List<MaterialUsedDto> getReportsMaterialsUsed(@PathVariable int id){
        return brigadeDailyReportService.getReportsMaterialUsed(id);
    }


}
