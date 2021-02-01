package com.example.projekt.model;

import com.example.projekt.repository.BuildingDailyReportsJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BuildingDailyReportsTest {

    @Autowired
    private BuildingDailyReportsJpaRepository buildingDailyReportsJpaRepository;

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

}
