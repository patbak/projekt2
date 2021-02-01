package com.example.projekt.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "machines")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_machines")
    private int machineId;

    @Column(name = "name")
    private String machineName;

    @Column(name = "number")
    private String inventoryNumber;

    @Column(name = "power")
    private  int powerHP;

    @Column(name = "fuel_consumption")
    private float fuelConsumption;

    @Column(name = "tank_capacity")
    private int fuelTankCapacity;

    @Column(name = "year_of_production")
    private Date  yearOfProduction;

    @Column(name = "comments")
    private String comments;

   @OneToMany(
            mappedBy = "machine",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<MachineReportHasMachines> machineReportHasMachines;

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public int getPowerHP() {
        return powerHP;
    }

    public void setPowerHP(int powerHP) {
        this.powerHP = powerHP;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(int fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public Date getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Date yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


}
