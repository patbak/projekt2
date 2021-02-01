package com.example.projekt.model;

import javax.persistence.*;

@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salary")
    private int idSalary;
    @Column(name = "overtime_salary")
    private double overtimeSalary;
    @Column(name = "harmful_salary")
    private double harmfulHoursSalary;
    @Column(name = "night_hours_salary")
    private double nightHoursSalary;
    @Column(name = "hours_salary")
    private double hoursSalary;
    @Column(name = "amount_salary")
    private double amountSalary;

    @ManyToOne
    @JoinColumn(name = "workers_id_worker")
    private  Employee employee;

    public void Salary(
            double hoursSalary,
            double overtimeSalary,
            double harmfulHoursSalary,
            double nightHoursSalary
    ){
        this.hoursSalary=hoursSalary;
        this.overtimeSalary=overtimeSalary;
        this.nightHoursSalary=nightHoursSalary;
        this.harmfulHoursSalary=harmfulHoursSalary;
    }

    public void countAmountSalary(){
        this.amountSalary=this.hoursSalary+this.harmfulHoursSalary+this.nightHoursSalary+this.overtimeSalary;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getAmountSalary() {
        return amountSalary;
    }

    public void setAmountSalary(double amountSalary) {
        this.amountSalary = amountSalary;
    }
}
