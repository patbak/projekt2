package com.example.projekt.service;

import com.example.projekt.entity.*;
import com.example.projekt.model.*;
import com.example.projekt.repository.DailyWorkReportJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BrigadeDailyReportService {

    @Autowired
    private DailyWorkReportJpaRepository jpaRepository;
    @Autowired
    private BuildingDailyReportDtoService buildingDailyReportDtoService;
    @Autowired
    private EngineerService engineerService;

    public List<BrigadeDailyReportDto> getBrigadeReports(){
        List<DailyWorkReport> dailyWorkReports = jpaRepository.findAll();
        List<BrigadeDailyReportDto> brigadeDailyReportDtoList = new ArrayList<>();
        for (DailyWorkReport dailyWorkReport:dailyWorkReports){
            Engineer engineer = engineerService.setEngineer(dailyWorkReport.getUser());
            BuildingDailyReportsDto buildingDailyReportsDto = buildingDailyReportDtoService.setBuildingReport(dailyWorkReport.getBuildingDailyReports());
            BrigadeDailyReportDto brigadeDailyReportDto = new BrigadeDailyReportDto(
                    dailyWorkReport.getDailyWorkReportId(),
                    dailyWorkReport.getReportDate(),
                    dailyWorkReport.getReportNumber(),
                    engineer,
                    buildingDailyReportsDto
                    );
            brigadeDailyReportDtoList.add(brigadeDailyReportDto);

        }
        return brigadeDailyReportDtoList;

    }

    public BrigadeDailyReportDto setBrigadeReport(DailyWorkReport dailyWorkReport){
        Engineer engineer = engineerService.setEngineer(dailyWorkReport.getUser());
        BuildingDailyReportsDto buildingDailyReportsDto = buildingDailyReportDtoService.setBuildingReport(dailyWorkReport.getBuildingDailyReports());
        BrigadeDailyReportDto brigadeDailyReportDto = new BrigadeDailyReportDto(
                dailyWorkReport.getDailyWorkReportId(),
                dailyWorkReport.getReportDate(),
                dailyWorkReport.getReportNumber(),
                engineer,
                buildingDailyReportsDto
        );
        return brigadeDailyReportDto;
    }









}
