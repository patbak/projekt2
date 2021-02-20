package com.example.projekt.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class OperatorWorkCardCommandDto {

    private int workerId;
    private LocalDate dateOfWorkCard;
    private int  harmfulHours;
    private LocalTime timeOfBegin;
    private LocalTime  timeOfEnd;

    public OperatorWorkCardCommandDto() {
    }

    public OperatorWorkCardCommandDto(int workerId, LocalDate dateOfWorkCard, int harmfulHours, LocalTime timeOfBegin, LocalTime timeOfEnd) {
        this.workerId = workerId;
        this.dateOfWorkCard = dateOfWorkCard;
        this.harmfulHours = harmfulHours;
        this.timeOfBegin = timeOfBegin;
        this.timeOfEnd = timeOfEnd;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
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
}
