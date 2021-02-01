package com.example.projekt.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "workers")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_worker")
    private int employeeId;

    @Column(name = "first_name")
    private String employeeName;

    @Column(name = "last_name")
    private String employeeLastName;

    @Column(name = "hourly_rate")
    private float hourlyRate;

    @Column(name = "foreman_addition")
    private float foremanAddition;
    @Column(name = "is_stacker_operator")
    private boolean isStackerOperator;
    @Column(name = "is_roller_operator")
    private boolean isRollerOperator;
    @Column(name = "is_excavator_operator")
    private boolean isExcavatorOperator;
    @Column(name = "is_backhole_operator")
    private boolean isBackholeOperator;
    @Column(name = "is_grader_operator")
    private boolean isGraderOperator;
    @Column(name = "is_miling_machine_operator")
    private boolean isMilingMachineOperator;
    @Column(name = "is_loader_operator")
    private boolean isLoaderOperator;
    @Column(name = "is_bulldozer_operator")
    private boolean isBulldozerOperator;
    @Column(name = "is_crane_operator")
    private boolean isCraneOperator;
    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Timesheet> timesheets;




    @OneToMany
            (
                    mappedBy = "employee",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true,
                    fetch = FetchType.LAZY
            )
    private List<Hours> hours;

    @OneToMany
            (
                    mappedBy = "employee",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true,
                    fetch = FetchType.LAZY
            )
    private List<Salary> salaries;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<MachineReportHasMachines> machineReportHasMachines;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<OperatorWorkCards> operatorWorkCards;


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }



    public List<Timesheet> getTimesheets() {
        return timesheets;
    }

    public void setTimesheets(List<Timesheet> timesheets) {
        this.timesheets = timesheets;
    }

    public List<Hours> getHours() {
        return hours;
    }

    public void setHours(List<Hours> hours) {
        this.hours = hours;
    }

    public List<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }

    public float getForemanAddition() {
        return foremanAddition;
    }

    public void setForemanAddition(float foremanAddition) {
        this.foremanAddition = foremanAddition;
    }

    public boolean isStackerOperator() {
        return isStackerOperator;
    }

    public void setStackerOperator(boolean stackerOperator) {
        isStackerOperator = stackerOperator;
    }

    public boolean isRollerOperator() {
        return isRollerOperator;
    }

    public void setRollerOperator(boolean rollerOperator) {
        isRollerOperator = rollerOperator;
    }

    public boolean isExcavatorOperator() {
        return isExcavatorOperator;
    }

    public void setExcavatorOperator(boolean excavatorOperator) {
        isExcavatorOperator = excavatorOperator;
    }

    public boolean isBackholeOperator() {
        return isBackholeOperator;
    }

    public void setBackholeOperator(boolean backholeOperator) {
        isBackholeOperator = backholeOperator;
    }

    public boolean isGraderOperator() {
        return isGraderOperator;
    }

    public void setGraderOperator(boolean graderOperator) {
        isGraderOperator = graderOperator;
    }

    public boolean isMilingMachineOperator() {
        return isMilingMachineOperator;
    }

    public void setMilingMachineOperator(boolean milingMachineOperator) {
        isMilingMachineOperator = milingMachineOperator;
    }

    public boolean isLoaderOperator() {
        return isLoaderOperator;
    }

    public void setLoaderOperator(boolean loaderOperator) {
        isLoaderOperator = loaderOperator;
    }

    public boolean isBulldozerOperator() {
        return isBulldozerOperator;
    }

    public void setBulldozerOperator(boolean bulldozerOperator) {
        isBulldozerOperator = bulldozerOperator;
    }

    public boolean isCraneOperator() {
        return isCraneOperator;
    }

    public void setCraneOperator(boolean craneOperator) {
        isCraneOperator = craneOperator;
    }

    public List<MachineReportHasMachines> getMachineReportHasMachines() {
        return machineReportHasMachines;
    }

    public void setMachineReportHasMachines(List<MachineReportHasMachines> machineReportHasMachines) {
        this.machineReportHasMachines = machineReportHasMachines;
    }

    public List<OperatorWorkCards> getOperatorWorkCards() {
        return operatorWorkCards;
    }

    public void setOperatorWorkCards(List<OperatorWorkCards> operatorWorkCards) {
        this.operatorWorkCards = operatorWorkCards;
    }
}
