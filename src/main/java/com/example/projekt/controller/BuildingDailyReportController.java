package com.example.projekt.controller;

import com.example.projekt.entity.BuildingDailyReportsDto;
import com.example.projekt.entity.BuildingDto;
import com.example.projekt.service.BuildingDailyReportDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuildingDailyReportController {

    @Autowired
    private BuildingDailyReportDtoService buildingDailyReportDtoService;

    @GetMapping("/BuildingsDailyReports")
    public List<BuildingDailyReportsDto> getBuildingDailyReports(){

        List<BuildingDailyReportsDto> buildingDailyReportsDtoList = buildingDailyReportDtoService.getBuildingReports();
        return buildingDailyReportsDtoList;
    }

}
