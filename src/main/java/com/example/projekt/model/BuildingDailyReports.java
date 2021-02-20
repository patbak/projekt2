package com.example.projekt.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "building_daily_reports")
public class BuildingDailyReports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_building_daily_report")
    private int idBuildingDailyReport;

    @Column(name = "date")
    private Date reportDate;

  @ManyToOne
  @JoinColumn(name = "buildings_id_building")
  private   ConstructionSite constructionSite;

  @ManyToOne
  @JoinColumn(name = "weather_conditions_id_weather_condition")
  private WeatherConditions weatherConditions;

    @OneToMany(
            mappedBy = "buildingDailyReports", //dwukierunkowa relacja, pomogło przy sypaniu się aplikacji,
            // gdy odwoływało się do relacji powiązanych manytoone
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Comment> comments;


    @OneToMany(
            mappedBy = "buildingDailyReports",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DailyMachineWorkReport> dailyMachineWorkReports;

    @OneToMany(
            mappedBy = "buildingDailyReports",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DailyWorkReport> dailyWorkReports;

    public BuildingDailyReports() {
    }

    public BuildingDailyReports(Date reportDate, ConstructionSite constructionSite) {
        this.reportDate = reportDate;
        this.constructionSite = constructionSite;
    }

    public int getIdBuildingDailyReport() {
        return idBuildingDailyReport;
    }

    public void setIdBuildingDailyReport(int idBuildingDailyReport) {
        this.idBuildingDailyReport = idBuildingDailyReport;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public ConstructionSite getConstructionSite() {
        return constructionSite;
    }

    public void setConstructionSite(ConstructionSite constructionSite) {
        this.constructionSite = constructionSite;
    }

    public WeatherConditions getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(WeatherConditions weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<DailyMachineWorkReport> getDailyMachineWorkReports() {
        return dailyMachineWorkReports;
    }

    public void setDailyMachineWorkReports(List<DailyMachineWorkReport> dailyMachineWorkReports) {
        this.dailyMachineWorkReports = dailyMachineWorkReports;
    }

    public List<DailyWorkReport> getDailyWorkReports() {
        return dailyWorkReports;
    }

    public void setDailyWorkReports(List<DailyWorkReport> dailyWorkReports) {
        this.dailyWorkReports = dailyWorkReports;
    }
}
