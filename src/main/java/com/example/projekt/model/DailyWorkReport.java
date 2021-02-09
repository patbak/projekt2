package com.example.projekt.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "brigade_daily_reports")
public class DailyWorkReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brigade_daily_report")
    private int DailyWorkReportId;

    @Column(name = "date")
    private Date reportDate;

    @Column(name = "report_number")
    private String reportNumber;


    @ManyToOne
    @JoinColumn(name = "users_id_user")
     private User user;

    @ManyToOne
    @JoinColumn(name = "buildings_id_building")
    private ConstructionSite constructionSite;

    @ManyToOne
    @JoinColumn(name = "building_daily_reports_id_building_daily_report")
    private BuildingDailyReports buildingDailyReports;


    @OneToMany(
            mappedBy = "dailyWorkReport",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<UsedMaterial> usedMaterials;

    @OneToMany(
            mappedBy = "dailyWorkReport",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<WorkDone> worksDone;

    @OneToMany(
            mappedBy = "dailyWorkReport",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Timesheet> timesheets;

    public int getDailyWorkReportId() {
        return DailyWorkReportId;
    }

    public void setDailyWorkReportId(int dailyWorkReportId) {
        DailyWorkReportId = dailyWorkReportId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ConstructionSite getConstructionSite() {
        return constructionSite;
    }

    public void setConstructionSite(ConstructionSite constructionSite) {
        this.constructionSite = constructionSite;
    }

    public List<UsedMaterial> getUsedMaterials() {
        return usedMaterials;
    }

    public void setUsedMaterials(List<UsedMaterial> usedMaterials) {
        this.usedMaterials = usedMaterials;
    }

    public List<Timesheet> getTimesheets() {
        return timesheets;
    }

    public void setTimesheets(List<Timesheet> timesheets) {
        this.timesheets = timesheets;
    }

    public List<WorkDone> getWorksDone() {
        return worksDone;
    }

    public void setWorksDone(List<WorkDone> worksDone) {
        this.worksDone = worksDone;
    }

    public BuildingDailyReports getBuildingDailyReports() {
        return buildingDailyReports;
    }

    public void setBuildingDailyReports(BuildingDailyReports buildingDailyReports) {
        this.buildingDailyReports = buildingDailyReports;
    }
}
