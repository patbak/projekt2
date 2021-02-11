package com.example.projekt.entity;

import java.sql.Date;

public class DailyReportCommandDto {

    private int buildingId;

    private Date date;

    private int weatherConditionId;

    public DailyReportCommandDto(int buildingId, Date date, int weatherConditionId) {
        this.buildingId = buildingId;
        this.date = date;
        this.weatherConditionId = weatherConditionId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getWeatherConditionId() {
        return weatherConditionId;
    }

    public void setWeatherConditionId(int weatherConditionId) {
        this.weatherConditionId = weatherConditionId;
    }
}
