package com.example.projekt.model;

import javax.persistence.*;

@Entity
@Table(name = "equipment_daily_reports_has_machines")
public class MachineReportHasMachines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_has_machines")
    private int hasMachineId;

    @Column(name = "work_hours")
    private float workHours;

    @ManyToOne
    @JoinColumn(name = "equipment_daily_reports_id_equipment_daily_report")
    private DailyMachineWorkReport dailyMachineWorkReport;

    @ManyToOne
    @JoinColumn(name = "machines_id_machines")
    private  Machine machine;

    @ManyToOne
    @JoinColumn(name = "workers_id_worker")
    private  Employee employee;

    public MachineReportHasMachines() {
    }

    public MachineReportHasMachines(DailyMachineWorkReport dailyMachineWorkReport, Machine machine, Employee employee) {
        this.dailyMachineWorkReport = dailyMachineWorkReport;
        this.machine = machine;
        this.employee = employee;
    }

    public int getHasMachineId() {
        return hasMachineId;
    }

    public void setHasMachineId(int hasMachineId) {
        this.hasMachineId = hasMachineId;
    }

    public DailyMachineWorkReport getDailyMachineWorkReport() {
        return dailyMachineWorkReport;
    }

    public void setDailyMachineWorkReport(DailyMachineWorkReport dailyMachineWorkReport) {
        this.dailyMachineWorkReport = dailyMachineWorkReport;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public float getWorkHours() {
        return workHours;
    }

    public void setWorkHours(float workHours) {
        this.workHours = workHours;
    }
}
