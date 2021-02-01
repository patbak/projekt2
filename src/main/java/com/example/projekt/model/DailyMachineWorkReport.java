package com.example.projekt.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "equipment_daily_reports")
public class DailyMachineWorkReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipment_daily_report")
    private int DailyMachineWorkReportId;

    @Column(name = "report_number")
    private String reportNumber;

    @Column(name = "date")
    private Date reportDate;

    @Column(name = "work")
    private String task;


    @ManyToOne
    @JoinColumn(name = "building_daily_reports_id_building_daily_report")
    private BuildingDailyReports buildingDailyReports;

    @ManyToOne
    @JoinColumn(name = "users_id_user")
    private User user;

    @OneToMany(
            mappedBy = "dailyMachineWorkReport",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MachineReportHasMachines> machineReportHasMachinesList;

    @OneToMany(
            mappedBy = "dailyMachineWorkReport",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OperatorWorkCards> operatorWorkCards;


    public int getDailyMachineWorkReportId() {
        return DailyMachineWorkReportId;
    }

    public void setDailyMachineWorkReportId(int dailyMachineWorkReportId) {
        DailyMachineWorkReportId = dailyMachineWorkReportId;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public BuildingDailyReports getBuildingDailyReports() {
        return buildingDailyReports;
    }

    public void setBuildingDailyReports(BuildingDailyReports buildingDailyReports) {
        this.buildingDailyReports = buildingDailyReports;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<MachineReportHasMachines> getMachineReportHasMachinesList() {
        return machineReportHasMachinesList;
    }

    public void setMachineReportHasMachinesList(List<MachineReportHasMachines> machineReportHasMachinesList) {
        this.machineReportHasMachinesList = machineReportHasMachinesList;
    }

    public List<OperatorWorkCards> getOperatorWorkCards() {
        return operatorWorkCards;
    }

    public void setOperatorWorkCards(List<OperatorWorkCards> operatorWorkCards) {
        this.operatorWorkCards = operatorWorkCards;
    }
}
