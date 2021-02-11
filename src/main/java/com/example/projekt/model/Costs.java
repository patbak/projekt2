package com.example.projekt.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "costs")
public class Costs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cost")
    private int id;

    @Column(name = "workers_cost")
    private float workersCost;
    @Column(name = "equipment_cost")
    private float equipmentCost;
    @Column(name = "material_cost")
    private float materialCost;
    @Column(name = "monthly_cost")
    private float monthlyCost;
    @Column(name = "total_cost")
    private float totalCost;

   @ManyToOne
    @JoinColumn(name = "buildings_id_building")
    private ConstructionSite constructionSite;

    public Costs() {
    }

    public Costs(int id, float workersCost, float equipmentCost, float materialCost, float monthlyCost, float totalCost) {
        this.id = id;
        this.workersCost = workersCost;
        this.equipmentCost = equipmentCost;
        this.materialCost = materialCost;
        this.monthlyCost = monthlyCost;
        this.totalCost = totalCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getWorkersCost() {
        return workersCost;
    }

    public void setWorkersCost(float workersCost) {
        this.workersCost = workersCost;
    }

    public float getEquipmentCost() {
        return equipmentCost;
    }

    public void setEquipmentCost(float equipmentCost) {
        this.equipmentCost = equipmentCost;
    }

    public float getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(float materialCost) {
        this.materialCost = materialCost;
    }

    public float getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(float monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }
}
