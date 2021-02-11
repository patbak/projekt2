package com.example.projekt.controller;

import com.example.projekt.entity.BuildingDailyReportsDto;
import com.example.projekt.entity.BuildingDto;
import com.example.projekt.entity.DailyReportCommandDto;
import com.example.projekt.service.BuildingDailyReportDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BuildingDailyReportController {

    @Autowired
    private BuildingDailyReportDtoService buildingDailyReportDtoService;

    @GetMapping("/daily-reports/{id}")
    public BuildingDailyReportsDto getBuildingDailyReport(@PathVariable int id){
        return buildingDailyReportDtoService.getBuildingDailyReport(id);
    }

    @PostMapping("/daily-reports")
    public ResponseEntity<String> createDailyReport(@RequestBody DailyReportCommandDto dailyReportCommandDto){

       buildingDailyReportDtoService.createBuildingReport(dailyReportCommandDto);
        return new ResponseEntity<String>("Dodano raport.", HttpStatus.CREATED);
    }

}
