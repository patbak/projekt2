package com.example.projekt.entity;

import com.example.projekt.model.BuildingDailyReports;
import com.example.projekt.model.DailyWorkReport;

import java.sql.Date;

public class BrigadeDailyReportDto {

    private int id;

    private Date date;

    private String reportNumber;

    private Engineer author;

    private BuildingDailyReportsDto buildingDailyReports;

    public BrigadeDailyReportDto() {
    }

    public BrigadeDailyReportDto(int id, Date date, String reportNumber, Engineer author, BuildingDailyReportsDto buildingDailyReports) {
        this.id = id;
        this.date = date;
        this.reportNumber = reportNumber;
        this.author = author;
        this.buildingDailyReports = buildingDailyReports;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public Engineer getAuthor() {
        return author;
    }

    public void setAuthor(Engineer author) {
        this.author = author;
    }

    public BuildingDailyReportsDto getBuildingDailyReports() {
        return buildingDailyReports;
    }

    public void setBuildingDailyReports(BuildingDailyReportsDto buildingDailyReports) {
        this.buildingDailyReports = buildingDailyReports;
    }
}
