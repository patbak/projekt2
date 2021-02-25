package com.example.projekt.dto;

public class WeatherConditionsDto {

    private int id;

    private String weatherCondition;


    public WeatherConditionsDto(int idWeatherCondition, String weatherCondition) {
        this.id = idWeatherCondition;
        this.weatherCondition = weatherCondition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }
}
