package com.example.projekt.entity;

import java.sql.Date;
import java.util.List;

public class BuildingCommandDto {

    private int id;

    private String buildingNumber;

    private String name;

    private String coordinates;

    private Date plannedStartDate;

    private Date realStartDate;

    private Date plannedEndDate;

    private Date realEndDate;

    private List<Integer> engineersIds;

    private int supervisorId;


    public BuildingCommandDto(int id, String buildingNumber, String name, String coordinates, Date plannedStartDate, Date realStartDate, Date plannedEndDate, Date realEndDate, List<Integer> engineersIds, int supervisorId) {
        this.id = id;
        this.buildingNumber = buildingNumber;
        this.name = name;
        this.coordinates = coordinates;
        this.plannedStartDate = plannedStartDate;
        this.realStartDate = realStartDate;
        this.plannedEndDate = plannedEndDate;
        this.realEndDate = realEndDate;
        this.engineersIds = engineersIds;
        this.supervisorId = supervisorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getRealStartDate() {
        return realStartDate;
    }

    public void setRealStartDate(Date realStartDate) {
        this.realStartDate = realStartDate;
    }

    public Date getPlannedEndDate() {
        return plannedEndDate;
    }

    public void setPlannedEndDate(Date plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public Date getRealEndDate() {
        return realEndDate;
    }

    public void setRealEndDate(Date realEndDate) {
        this.realEndDate = realEndDate;
    }

    public List<Integer> getEngineersIds() {
        return engineersIds;
    }

    public void setEngineersIds(List<Integer> engineersIds) {
        this.engineersIds = engineersIds;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }
}
