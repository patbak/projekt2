package com.example.projekt.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "costs")
public class Costs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cost")
    private int id;

    @Column(name = "workers_cost")
    private double workersCost;
    @Column(name = "equipment_cost")
    private double equipmentCost;
    @Column(name = "material_cost")
    private double materialCost;
    @Column(name = "monthly_cost")
    private double monthlyCost;
    @Column(name = "total_cost")
    private double totalCost;
    @Column(name = "date")
    private LocalDate date;

   @ManyToOne
    @JoinColumn(name = "buildings_id_building")
    private ConstructionSite constructionSite;

    public Costs() {
    }

    public Costs(int id, double workersCost, double equipmentCost, double materialCost, double monthlyCost, double totalCost, ConstructionSite constructionSite) {
        this.id = id;
        this.workersCost = workersCost;
        this.equipmentCost = equipmentCost;
        this.materialCost = materialCost;
        this.monthlyCost = monthlyCost;
        this.totalCost = totalCost;
        this.constructionSite = constructionSite;
    }

    public void addWorkerCosts(double workersCost){
        this.workersCost+=workersCost;
    }

    public void addMaterialCost(double materialCost){
        this.materialCost+=materialCost;
    }

    public void addEquipmentCost(double equipmentCost){ this.equipmentCost+=equipmentCost;}

    public void countmonthlyCost(double workersCost, double equipmentCost, double materialCost){
        this.monthlyCost= workersCost+equipmentCost+materialCost;
    }

    public void countTotalCosts(double totalCost, double monthlyCost){
        this.totalCost= totalCost+monthlyCost;
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

    public ConstructionSite getConstructionSite() {
        return constructionSite;
    }

    public void setConstructionSite(ConstructionSite constructionSite) {
        this.constructionSite = constructionSite;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
