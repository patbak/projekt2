package com.example.projekt.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "operators_work_cards")
public class OperatorWorkCards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_work_card")
    private int idWorkCard;

    @Column(name = "date_of_work_card")
    private LocalDate workCardDate;

    @Column(name = "time_of_begin")
    private LocalTime startTimeOfWork;

    @Column(name = "time_of_end")
    private LocalTime endTimeOfWork;

    @Column(name = "harmful_hours")
    private int harmfulHours;

    @ManyToOne
    @JoinColumn(name = "workers_id_worker")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "equipment_daily_reports_id_equipment_daily_report")
    private DailyMachineWorkReport dailyMachineWorkReport;

    public OperatorWorkCards() {
    }

    public OperatorWorkCards(LocalDate workCardDate, LocalTime startTimeOfWork, LocalTime endTimeOfWork, int harmfulHours, Employee employee, DailyMachineWorkReport dailyMachineWorkReport) {
        this.workCardDate = workCardDate;
        this.startTimeOfWork = startTimeOfWork;
        this.endTimeOfWork = endTimeOfWork;
        this.harmfulHours = harmfulHours;
        this.employee = employee;
        this.dailyMachineWorkReport = dailyMachineWorkReport;
    }

    public int getIdWorkCard() {
        return idWorkCard;
    }

    public void setIdWorkCard(int idWorkCard) {
        this.idWorkCard = idWorkCard;
    }

    public LocalDate getWorkCardDate() {
        return workCardDate;
    }

    public void setWorkCardDate(LocalDate workCardDate) {
        this.workCardDate = workCardDate;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public DailyMachineWorkReport getDailyMachineWorkReport() {
        return dailyMachineWorkReport;
    }

    public void setDailyMachineWorkReport(DailyMachineWorkReport dailyMachineWorkReport) {
        this.dailyMachineWorkReport = dailyMachineWorkReport;
    }
}
