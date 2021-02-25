package com.example.projekt.dto;

import java.sql.Date;

public class BuildingDailyReportsDto {
    private int id;

    private BuildingDto building;

    private Date date;

    private WeatherConditionsDto weatherCondition;

    public BuildingDailyReportsDto(int id, BuildingDto building, Date date, WeatherConditionsDto weatherCondition) {
        this.id = id;
        this.building = building;
        this.date = date;
        this.weatherCondition = weatherCondition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BuildingDto getBuilding() {
        return building;
    }

    public void setBuilding(BuildingDto building) {
        this.building = building;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public WeatherConditionsDto getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(WeatherConditionsDto weatherCondition) {
        this.weatherCondition = weatherCondition;
    }
}
