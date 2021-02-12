package com.example.projekt.controller;

import com.example.projekt.entity.*;
import com.example.projekt.service.BuildingDailyReportDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
        System.out.println(dailyReportCommandDto.getBuildingId());
        System.out.println(dailyReportCommandDto.getDate());
        System.out.println(dailyReportCommandDto.getWeatherConditionId());
        buildingDailyReportDtoService.createBuildingReport(dailyReportCommandDto);
        return new ResponseEntity<String>("Dodano raport.", HttpStatus.CREATED);
    }

    @GetMapping("/daily-reports/{id}/comments")
    public List<CommentsDto> getBuildingDailyReportComments(@PathVariable int id){
        return buildingDailyReportDtoService.getBuildingDailyReportComments(id);
    }

    @GetMapping("/daily-reports/{id}/equipment-daily-reports")
    public List<EquipmentDailyReportDto> getBuildingDailyReportEquipmentReports(@PathVariable int id){
        return buildingDailyReportDtoService.getEquipmentReportsByDailyReportId(id);
    }

    @GetMapping("/daily-reports/{id}/brigade-daily-reports")
    public List<BrigadeDailyReportDto> getBuildingDailyReportBrigadeReports(@PathVariable int id){
        return buildingDailyReportDtoService.getBrigadeReportsByBuildingReports(id);
    }


}
