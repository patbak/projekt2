package com.example.projekt.dto;


import java.time.LocalDate;

public class HoursDto {

    private int idHours;

    private int hours;

    private int nightHours;

    private int harmfulHours;

    private int overtime;

    private LocalDate date;

    private BuildingDto building;

    private WorkerDto worker;

    public HoursDto() {
    }

    public HoursDto(int idHours, int hours, int nightHours, int harmfulHours, int overtime, LocalDate date, BuildingDto building, WorkerDto worker) {
        this.idHours = idHours;
        this.hours = hours;
        this.nightHours = nightHours;
        this.harmfulHours = harmfulHours;
        this.overtime = overtime;
        this.date = date;
        this.building = building;
        this.worker = worker;
    }

    public int getIdHours() {
        return idHours;
    }

    public void setIdHours(int idHours) {
        this.idHours = idHours;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getNightHours() {
        return nightHours;
    }

    public void setNightHours(int nightHours) {
        this.nightHours = nightHours;
    }

    public int getHarmfulHours() {
        return harmfulHours;
    }

    public void setHarmfulHours(int harmfulHours) {
        this.harmfulHours = harmfulHours;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public WorkerDto getWorker() {
        return worker;
    }

    public void setWorker(WorkerDto worker) {
        this.worker = worker;
    }

    public BuildingDto getBuilding() {
        return building;
    }

    public void setBuilding(BuildingDto building) {
        this.building = building;
    }
}
