package com.example.projekt.entity;

import java.sql.Date;
import java.util.List;

public class EquipmentDailyReportDto {

    private int id;

    private BuildingDailyReportsDto buildingDailyReport;

    private Date date;

    private Engineer author;

    private String reportNumber;

    private String Work;


    public EquipmentDailyReportDto(int id, BuildingDailyReportsDto buildingDailyReportsDto, Date date, Engineer author, String reportNumber, String work) {
        this.id = id;
        this.buildingDailyReport = buildingDailyReportsDto;
        this.date = date;
        this.author = author;
        this.reportNumber = reportNumber;
        Work = work;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BuildingDailyReportsDto getBuildingDailyReport() {
        return buildingDailyReport;
    }

    public void setBuildingDailyReport(BuildingDailyReportsDto buildingDailyReport) {
        this.buildingDailyReport = buildingDailyReport;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Engineer getAuthor() {
        return author;
    }

    public void setAuthor(Engineer author) {
        this.author = author;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getWork() {
        return Work;
    }

    public void setWork(String work) {
        Work = work;
    }

}
