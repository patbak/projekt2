package com.example.projekt.dto;

public class MachineDto {

    private int id;

    private String name;

    private String number;

    private int power;

    private float fuelConsumption;

    private int tankCapacity;

    private int yearOfProduction;

    private String comments;


    public MachineDto(int id, String name, String number, int power, float fuelConsumption, int tankCapacity, int yearOfProduction, String comments) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.power = power;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
        this.yearOfProduction = yearOfProduction;
        this.comments = comments;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }
}
