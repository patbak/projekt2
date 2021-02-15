package com.example.projekt.model;

import com.example.projekt.repository.BuildingDailyReportsJpaRepository;
import com.example.projekt.service.DateConverterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BuildingDailyReportsTest {

    @Autowired
    private BuildingDailyReportsJpaRepository buildingDailyReportsJpaRepository;
    @Autowired
    private DateConverterService dateConverterService;

    @Test
    @Transactional
    public void getReportsTest()throws Exception{
        List<BuildingDailyReports> buildingDailyReports = buildingDailyReportsJpaRepository.findAll();

        assertTrue(buildingDailyReports.size()>0);

        BuildingDailyReports buildingDailyReport = new BuildingDailyReports();
        buildingDailyReport = buildingDailyReports.get(0);
        System.out.println(buildingDailyReport.getIdBuildingDailyReport());
        System.out.println(buildingDailyReport.getReportDate());
        WeatherConditions weatherConditions = buildingDailyReport.getWeatherConditions();
        System.out.println(weatherConditions.getWeatherCondition());
        List<Comment> comments = buildingDailyReport.getComments();
        System.out.println(comments.get(0).getText());
        ConstructionSite constructionSite = buildingDailyReport.getConstructionSite();
        System.out.println(constructionSite.getName()+" "+constructionSite.getBuildingNumber());
        List<DailyMachineWorkReport> dailyMachineWorkReports = buildingDailyReport.getDailyMachineWorkReports();
        System.out.println(dailyMachineWorkReports.get(0).getReportDate()+" "+dailyMachineWorkReports.get(0).getTask());
        List<DailyWorkReport> dailyWorkReports = buildingDailyReport.getDailyWorkReports();
        System.out.println(dailyWorkReports.get(0).getReportDate()+" "+dailyWorkReports.get(0).getReportNumber());
    }

    @Test
    @Transactional
    public void getReportsByDateAndId(){
        LocalDate date1 = LocalDate.parse("2021-01-01");
        LocalDate date2 = LocalDate.parse("2021-01-31");
        List<BuildingDailyReports> buildingDailyReportsList =
                buildingDailyReportsJpaRepository.findAllByReportDateBetweenAndConstructionSite_ConstructionSiteId(
                    dateConverterService.convertToDateViaSqlDate(date1),
                        dateConverterService.convertToDateViaSqlDate(date2),
                        3
                );

        for (BuildingDailyReports buildingDailyReports:buildingDailyReportsList){
            System.out.println(buildingDailyReports.getIdBuildingDailyReport());
            System.out.println(buildingDailyReports.getReportDate());
            System.out.println(buildingDailyReports.getWeatherConditions().getWeatherCondition());
        }
    }

}
