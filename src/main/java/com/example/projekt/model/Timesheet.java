package com.example.projekt.model;


import javax.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "work_cards")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_work_card")
    private int TimesheetId;

    @Column(name = "time_of_begin")
    private LocalTime startTimeOfWork;

    @Column(name = "time_of_end")
    private LocalTime endTimeOfWork;

    @Column(name = "harmful_hours")
    private int harmfulHours;

    @Column(name = "date_of_work_card")
    private LocalDate timesheetDate;

    @ManyToOne
    @JoinColumn(name = "brigade_daily_reports_id_brigade_daily_report")
    private DailyWorkReport dailyWorkReport;

    @ManyToOne
    @JoinColumn(name = "workers_id_worker")
    private Employee employee;

    public int getTimesheetId() {
        return TimesheetId;
    }

    public void setTimesheetId(int timesheetId) {
        TimesheetId = timesheetId;
    }

    public LocalTime getStartTimeOfWork() {
        return startTimeOfWork;
    }

    public void setStartTimeOfWork(LocalTime startTimeOfWork) {
        this.startTimeOfWork = startTimeOfWork;
    }

    public LocalTime getEndTimeOfWork() {
        return endTimeOfWork;
    }

    public void setEndTimeOfWork(LocalTime endTimeOfWork) {
        this.endTimeOfWork = endTimeOfWork;
    }

    public int getHarmfulHours() {
        return harmfulHours;
    }

    public void setHarmfulHours(int harmfulHours) {
        this.harmfulHours = harmfulHours;
    }

    public LocalDate getTimesheetDate() {
        return timesheetDate;
    }

    public void setTimesheetDate(LocalDate timesheetDate) {
        this.timesheetDate = timesheetDate;
    }

    public DailyWorkReport getDailyWorkReport() {
        return dailyWorkReport;
    }

    public void setDailyWorkReport(DailyWorkReport dailyWorkReport) {
        this.dailyWorkReport = dailyWorkReport;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
