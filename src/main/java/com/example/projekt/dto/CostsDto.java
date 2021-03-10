package com.example.projekt.dto;

import com.example.projekt.model.ConstructionSite;

import java.time.LocalDate;


public class CostsDto {

    private int id;

    private double workersCost;

    private double equipmentCost;

    private double materialCost;

    private double monthlyCost;

    private double totalCost;

    private LocalDate date;

    private BuildingDto buildingDto;

    public CostsDto() {
    }

    public CostsDto(int id, double workersCost, double equipmentCost, double materialCost, double monthlyCost, double totalCost, LocalDate date, BuildingDto buildingDto) {
        this.id = id;
        this.workersCost = workersCost;
        this.equipmentCost = equipmentCost;
        this.materialCost = materialCost;
        this.monthlyCost = monthlyCost;
        this.totalCost = totalCost;
        this.date = date;
        this.buildingDto = buildingDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWorkersCost() {
        return workersCost;
    }

    public void setWorkersCost(double workersCost) {
        this.workersCost = workersCost;
    }

    public double getEquipmentCost() {
        return equipmentCost;
    }

    public void setEquipmentCost(double equipmentCost) {
        this.equipmentCost = equipmentCost;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BuildingDto getBuildingDto() {
        return buildingDto;
    }

    public void setBuildingDto(BuildingDto buildingDto) {
        this.buildingDto = buildingDto;
    }
}
