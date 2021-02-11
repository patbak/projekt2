package com.example.projekt.entity;

import com.example.projekt.model.User;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


public class BuildingDto {

    private int id;

    private String buildingNumber;

    private String name;

    private String coordinates;

    private Date plannedStartDate;

    private Date realStartDate;

    private Date plannedEndDate;

    private Date realEndDate;

    private List<Engineer> engineers;

    private Engineer supervisor;

    public BuildingDto() {
    }

    public BuildingDto(
            int id,
            String buildingNumber,
            String name,
            String coordinates,
            Date plannedStartDate,
            Date realStartDate,
            Date plannedEndDate,
            Date realEndDate,
            List<Engineer> engineers,
            Engineer supervisor
            ){
        this.id=id;
        this.buildingNumber=buildingNumber;
        this.name=name;
        this.coordinates=coordinates;
        this.plannedStartDate=plannedStartDate;
        this.realStartDate=realStartDate;
        this.plannedEndDate=plannedEndDate;
        this.realStartDate=realStartDate;
        this.realEndDate=realEndDate;
        this.engineers=engineers;
        this.supervisor=supervisor;
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

    public List<Engineer> getEngineers() {
        return engineers;
    }

    public void setEngineers(List<Engineer> engineers) {
        this.engineers = engineers;
    }

    public Engineer getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Engineer supervisor) {
        this.supervisor = supervisor;
    }
}
