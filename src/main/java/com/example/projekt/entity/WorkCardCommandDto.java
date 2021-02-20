package com.example.projekt.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class WorkCardCommandDto {

    private LocalDate dateOfWork;

    private int harmfulHours;

    private LocalTime timeOfBegin;

    private LocalTime timeOfEnd;

    private int workerId;

    public WorkCardCommandDto(LocalDate dateOfWork, int harmfulHours, LocalTime timeOfBegin, LocalTime timeOfEnd, int workerId) {
        this.dateOfWork = dateOfWork;
        this.harmfulHours = harmfulHours;
        this.timeOfBegin = timeOfBegin;
        this.timeOfEnd = timeOfEnd;
        this.workerId = workerId;
    }

    public LocalDate getDateOfWork() {
        return dateOfWork;
    }

    public void setDateOfWork(LocalDate dateOfWork) {
        this.dateOfWork = dateOfWork;
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

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }
}
