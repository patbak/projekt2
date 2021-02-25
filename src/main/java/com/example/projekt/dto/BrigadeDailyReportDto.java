package com.example.projekt.dto;

import java.sql.Date;

public class BrigadeDailyReportDto {

    private int id;

    private Date date;

    private String reportNumber;

    private Engineer author;

    private BuildingDailyReportsDto buildingDailyReport;

    public BrigadeDailyReportDto() {
    }

    public BrigadeDailyReportDto(int id, Date date, String reportNumber, Engineer author, BuildingDailyReportsDto buildingDailyReports) {
        this.id = id;
        this.date = date;
        this.reportNumber = reportNumber;
        this.author = author;
        this.buildingDailyReport = buildingDailyReports;
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

    public BuildingDailyReportsDto getBuildingDailyReport() {
        return buildingDailyReport;
    }

    public void setBuildingDailyReport(BuildingDailyReportsDto buildingDailyReport) {
        this.buildingDailyReport = buildingDailyReport;
    }
}
