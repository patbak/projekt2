package com.example.projekt.service;

import com.example.projekt.entity.BuildingDailyReportsDto;
import com.example.projekt.entity.BuildingDto;
import com.example.projekt.entity.DailyReportCommandDto;
import com.example.projekt.entity.WeatherConditionsDto;
import com.example.projekt.model.BuildingDailyReports;
import com.example.projekt.model.ConstructionSite;
import com.example.projekt.model.DailyWorkReport;
import com.example.projekt.model.WeatherConditions;
import com.example.projekt.repository.BuildingDailyReportsJpaRepository;
import com.example.projekt.repository.ConstructionSiteJpaRepository;
import com.example.projekt.repository.WeatherConditionsJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingDailyReportDtoService {

    @Autowired
    private BuildingService buildingService;
    @Autowired
    private  WeatherConditionsDtoService weatherConditionsDtoService;
    @Autowired
    private BuildingDailyReportsJpaRepository  buildingDailyReportsJpaRepository;
    @Autowired
    private ConstructionSiteJpaRepository constructionSiteJpaRepository;
    @Autowired
    private WeatherConditionsJpaRepository weatherConditionsJpaRepository;

    public BuildingDailyReportsDto setBuildingReport(BuildingDailyReports buildingDailyReports){
        BuildingDto buildingDto = buildingService.setBuilding(buildingDailyReports.getConstructionSite());
        WeatherConditionsDto weatherConditionsDto = weatherConditionsDtoService.setWeatherCondition(buildingDailyReports.getWeatherConditions());
        BuildingDailyReportsDto buildingDailyReportsDto = new BuildingDailyReportsDto(
                buildingDailyReports.getIdBuildingDailyReport(),
                buildingDto,
                buildingDailyReports.getReportDate(),
                weatherConditionsDto
        );
        return buildingDailyReportsDto;
    }

    public List<BuildingDailyReportsDto> getBuildingReports(){
        List<BuildingDailyReportsDto> buildingDailyReportsDtoList = new ArrayList<>();
        List<BuildingDailyReports> buildingDailyReports = buildingDailyReportsJpaRepository.findAll();
        for(BuildingDailyReports buildingDailyReport:buildingDailyReports){
            BuildingDto buildingDto = buildingService.setBuilding(buildingDailyReport.getConstructionSite());
            WeatherConditionsDto weatherConditionsDto = weatherConditionsDtoService.setWeatherCondition(buildingDailyReport.getWeatherConditions());
            BuildingDailyReportsDto buildingDailyReportsDto = new BuildingDailyReportsDto(
                    buildingDailyReport.getIdBuildingDailyReport(),
                    buildingDto,
                    buildingDailyReport.getReportDate(),
                    weatherConditionsDto
            );
            buildingDailyReportsDtoList.add(buildingDailyReportsDto);
        }
        return  buildingDailyReportsDtoList;
    }


    public BuildingDailyReportsDto getBuildingDailyReport(int id){
        BuildingDailyReports buildingDailyReport = buildingDailyReportsJpaRepository.getOne(id);
         BuildingDailyReportsDto buildingDailyReportsDto = setBuildingReport(buildingDailyReport);
         return buildingDailyReportsDto;
    }

    public void createBuildingReport(DailyReportCommandDto dailyReportCommandDto){
        ConstructionSite constructionSite = constructionSiteJpaRepository.getOne(dailyReportCommandDto.getBuildingId());
        WeatherConditions weatherConditions = weatherConditionsJpaRepository.getOne(dailyReportCommandDto.getWeatherConditionId());
        BuildingDailyReports buildingDailyReport = new BuildingDailyReports();
        buildingDailyReport.setConstructionSite(constructionSite);
        buildingDailyReport.setReportDate(dailyReportCommandDto.getDate());
        buildingDailyReport.setWeatherConditions(weatherConditions);
        buildingDailyReportsJpaRepository.saveAndFlush(buildingDailyReport);

    }

}
