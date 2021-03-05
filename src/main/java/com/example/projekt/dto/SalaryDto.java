package com.example.projekt.dto;

import com.example.projekt.model.Employee;

import java.time.LocalDate;


public class SalaryDto {


    private int idSalary;

    private double overtimeSalary;

    private double harmfulHoursSalary;

    private double nightHoursSalary;

    private double hoursSalary;

    private double amountSalary;

    private LocalDate date;

    private WorkerDto workerDto;


    public SalaryDto() {
    }

    public SalaryDto(int idSalary, double overtimeSalary, double harmfulHoursSalary, double nightHoursSalary, double hoursSalary, double amountSalary, LocalDate date, WorkerDto workerDto) {
        this.idSalary = idSalary;
        this.overtimeSalary = overtimeSalary;
        this.harmfulHoursSalary = harmfulHoursSalary;
        this.nightHoursSalary = nightHoursSalary;
        this.hoursSalary = hoursSalary;
        this.amountSalary = amountSalary;
        this.date = date;
        this.workerDto = workerDto;
    }

    public int getIdSalary() {
        return idSalary;
    }

    public void setIdSalary(int idSalary) {
        this.idSalary = idSalary;
    }

    public double getOvertimeSalary() {
        return overtimeSalary;
    }

    public void setOvertimeSalary(double overtimeSalary) {
        this.overtimeSalary = overtimeSalary;
    }

    public double getHarmfulHoursSalary() {
        return harmfulHoursSalary;
    }

    public void setHarmfulHoursSalary(double harmfulHoursSalary) {
        this.harmfulHoursSalary = harmfulHoursSalary;
    }

    public double getNightHoursSalary() {
        return nightHoursSalary;
    }

    public void setNightHoursSalary(double nightHoursSalary) {
        this.nightHoursSalary = nightHoursSalary;
    }

    public double getHoursSalary() {
        return hoursSalary;
    }

    public void setHoursSalary(double hoursSalary) {
        this.hoursSalary = hoursSalary;
    }

    public double getAmountSalary() {
        return amountSalary;
    }

    public void setAmountSalary(double amountSalary) {
        this.amountSalary = amountSalary;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public WorkerDto getWorkerDto() {
        return workerDto;
    }

    public void setWorkerDto(WorkerDto workerDto) {
        this.workerDto = workerDto;
    }
}
