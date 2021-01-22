package com.example.projekt.model;

import javax.persistence.*;

@Entity
@Table(name = "hours")
public class Hours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hours")
    private int idHours;
    @Column(name = "hours")
    private int hours;
    @Column(name = "night_hours")
    private int nightHours;
    @Column(name = "harmful_hours")
    private int harmfulHours;
    @Column(name = "overtime")
    private int overtime;
    @Column(name = "month")
    private String month;

    @ManyToOne
    @JoinColumn(name = "pracownicy_id_pracownika")
    private  Employee employee;

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getNightHours() {
        return nightHours;
    }

    public void setNightHours(int nightHours) {
        this.nightHours = nightHours;
    }

    public int getHarmfulHours() {
        return harmfulHours;
    }

    public void setHarmfulHours(int harmfulHours) {
        this.harmfulHours = harmfulHours;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void addHours(int hours){
        this.hours+=hours;
    }

    public void addOvertime(int overtime){
        this.overtime+=overtime;
    }

    public void addHarmfulHours(int harmfulHours){
        this.harmfulHours+=harmfulHours;
    }

    public void addNightHours(int nightHours){
        this.nightHours+=nightHours;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
