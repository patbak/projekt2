package com.example.projekt.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class WorkCardDto {

    private int id;

    private LocalDate dateOfWorkCard;

    private int harmfulHours;

    private LocalTime timeOfBegin;

    private LocalTime timeOfEnd;

    private WorkerDto worker;

    private BrigadeDailyReportDto brigadeDailyReport;

    public WorkCardDto(int id, LocalDate dateOfWorkCard, int harmfulHours, LocalTime timeOfBegin, LocalTime timeOfEnd, WorkerDto worker, BrigadeDailyReportDto brigadeDailyReport) {
        this.id = id;
        this.dateOfWorkCard = dateOfWorkCard;
        this.harmfulHours = harmfulHours;
        this.timeOfBegin = timeOfBegin;
        this.timeOfEnd = timeOfEnd;
        this.worker = worker;
        this.brigadeDailyReport = brigadeDailyReport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateOfWorkCard() {
        return dateOfWorkCard;
    }

    public void setDateOfWorkCard(LocalDate dateOfWorkCard) {
        this.dateOfWorkCard = dateOfWorkCard;
    }

    public int getHarmfulHours() {
        return harmfulHours;
    }

    public void setHarmfulHours(int harmfulHours) {
        this.harmfulHours = harmfulHours;
    }

    public LocalTime getTimeOfBegin() {
        return timeOfBegin;
    }

    public void setTimeOfBegin(LocalTime timeOfBegin) {
        this.timeOfBegin = timeOfBegin;
    }

    public LocalTime getTimeOfEnd() {
        return timeOfEnd;
    }

    public void setTimeOfEnd(LocalTime timeOfEnd) {
        this.timeOfEnd = timeOfEnd;
    }

    public WorkerDto getWorker() {
        return worker;
    }

    public void setWorker(WorkerDto worker) {
        this.worker = worker;
    }

    public BrigadeDailyReportDto getBrigadeDailyReport() {
        return brigadeDailyReport;
    }

    public void setBrigadeDailyReport(BrigadeDailyReportDto brigadeDailyReport) {
        this.brigadeDailyReport = brigadeDailyReport;
    }
}