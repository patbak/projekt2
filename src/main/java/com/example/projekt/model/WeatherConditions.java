package com.example.projekt.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "weather_conditions")
public class WeatherConditions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_weather_condition")
    private int idWeatherCondition;

    @Column(name = "weather_condition")
    private String weatherCondition;

    @OneToMany(
            mappedBy = "weatherConditions",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BuildingDailyReports> buildingDailyReportsList;


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

    public List<BuildingDailyReports> getBuildingDailyReportsList() {
        return buildingDailyReportsList;
    }

    public void setBuildingDailyReportsList(List<BuildingDailyReports> buildingDailyReportsList) {
        this.buildingDailyReportsList = buildingDailyReportsList;
    }
}
