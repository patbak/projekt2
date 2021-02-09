package com.example.projekt.entity;

import javax.persistence.Column;

public class WeatherConditionsDto {

    private int idWeatherCondition;

    private String weatherCondition;


    public WeatherConditionsDto(int idWeatherCondition, String weatherCondition) {
        this.idWeatherCondition = idWeatherCondition;
        this.weatherCondition = weatherCondition;
    }

    public int getIdWeatherCondition() {
        return idWeatherCondition;
    }

    public void setIdWeatherCondition(int idWeatherCondition) {
        this.idWeatherCondition = idWeatherCondition;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }
}
