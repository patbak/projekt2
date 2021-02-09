package com.example.projekt.entity;

import com.example.projekt.model.WorkDone;

import java.sql.Date;
import java.util.List;

public class EquipmentDailyReportDto {

    private int id;

    private BuildingDailyReportsDto buildingDailyReportsDto;

    private Date date;

    private Engineer author;

    private String reportNumber;

    private String Work;

    private List<MachineDto> machineDto;

    private List<WorkerDto> workerDtoList;

    public EquipmentDailyReportDto(int id, BuildingDailyReportsDto buildingDailyReportsDto, Date date, Engineer author, String reportNumber, String work, List<MachineDto> machineDto, List<WorkerDto> workerDtoList) {
        this.id = id;
        this.buildingDailyReportsDto = buildingDailyReportsDto;
        this.date = date;
        this.author = author;
        this.reportNumber = reportNumber;
        Work = work;
        this.machineDto = machineDto;
        this.workerDtoList = workerDtoList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BuildingDailyReportsDto getBuildingDailyReportsDto() {
        return buildingDailyReportsDto;
    }

    public void setBuildingDailyReportsDto(BuildingDailyReportsDto buildingDailyReportsDto) {
        this.buildingDailyReportsDto = buildingDailyReportsDto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Engineer getAuthor() {
        return author;
    }

    public void setAuthor(Engineer author) {
        this.author = author;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getWork() {
        return Work;
    }

    public void setWork(String work) {
        Work = work;
    }

    public List<MachineDto> getMachineDto() {
        return machineDto;
    }

    public void setMachineDto(List<MachineDto> machineDto) {
        this.machineDto = machineDto;
    }

    public List<WorkerDto> getWorkerDtoList() {
        return workerDtoList;
    }

    public void setWorkerDtoList(List<WorkerDto> workerDtoList) {
        this.workerDtoList = workerDtoList;
    }
}
