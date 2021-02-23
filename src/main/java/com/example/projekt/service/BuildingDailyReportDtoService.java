package com.example.projekt.service;

import com.example.projekt.entity.*;
import com.example.projekt.model.*;
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
    @Autowired
    private CommentService commentService;
    @Autowired
    private  EquipmentDailyReportService equipmentDailyReportService;
    @Autowired
    private BrigadeDailyReportService brigadeDailyReportService;
    @Autowired
    private DateConverterService dateConverterService;

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
        //WeatherConditions weatherConditions = weatherConditionsJpaRepository.getOne(dailyReportCommandDto.getWeatherConditionId());
        BuildingDailyReports buildingDailyReport = new BuildingDailyReports();
        buildingDailyReport.setConstructionSite(constructionSite);
        buildingDailyReport.setReportDate(dailyReportCommandDto.getDate());
        buildingDailyReport.setWeatherConditions(weatherConditionsDtoService.setRandomWeatherConditions());
        buildingDailyReportsJpaRepository.saveAndFlush(buildingDailyReport);

    }

    public List<CommentsDto> getBuildingDailyReportComments(int id){
        BuildingDailyReports buildingDailyReport = buildingDailyReportsJpaRepository.getOne(id);
       List<Comment> commentList =  buildingDailyReport.getComments();
       List<CommentsDto> commentsDtoList = new ArrayList<>();
       for(Comment comment:commentList){
           CommentsDto commentsDto = commentService.setComment(comment);
           commentsDtoList.add(commentsDto);
       }
       return commentsDtoList;
    }

    public List<EquipmentDailyReportDto> getEquipmentReportsByDailyReportId(int id){
    BuildingDailyReports buildingDailyReports = buildingDailyReportsJpaRepository.getOne(id);
    List<DailyMachineWorkReport> dailyMachineWorkReportsList = buildingDailyReports.getDailyMachineWorkReports();
    List<EquipmentDailyReportDto> equipmentDailyReportDtoList = new ArrayList<>();
    for(DailyMachineWorkReport dailyMachineWorkReport:dailyMachineWorkReportsList){
        EquipmentDailyReportDto equipmentDailyReportDto = equipmentDailyReportService.setEquipmentReport(dailyMachineWorkReport);
        equipmentDailyReportDtoList.add(equipmentDailyReportDto);
    }
    return equipmentDailyReportDtoList;
    }

    public List<BrigadeDailyReportDto> getBrigadeReportsByBuildingReports(int id){
        BuildingDailyReports buildingDailyReports = buildingDailyReportsJpaRepository.getOne(id);
       List<DailyWorkReport> dailyWorkReportList = buildingDailyReports.getDailyWorkReports();
       List<BrigadeDailyReportDto> brigadeDailyReportDtoList =new ArrayList<>();
       for(DailyWorkReport dailyWorkReport:dailyWorkReportList){
           BrigadeDailyReportDto brigadeDailyReportDto = brigadeDailyReportService.setBrigadeReport(dailyWorkReport);
           brigadeDailyReportDtoList.add(brigadeDailyReportDto);
       }
       return  brigadeDailyReportDtoList;
    }

    public void createBuilding(int id){
        ConstructionSite constructionSite = constructionSiteJpaRepository.getOne(id);
        LocalDate date = LocalDate.now();
        BuildingDailyReports buildingDailyReports = new BuildingDailyReports(dateConverterService.convertToDateViaSqlDate(date),constructionSite);
        buildingDailyReportsJpaRepository.saveAndFlush(buildingDailyReports);
    }

}
