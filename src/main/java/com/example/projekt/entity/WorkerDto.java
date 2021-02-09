package com.example.projekt.entity;

public class WorkerDto {

    private int id;

    private String firstName;

    private String lastName;

    private float hourlyRate;

    private float foremanAddition;

    private boolean isStackerOperator;

    private boolean isRollerOperator;

    private boolean isExcavatorOperator;

    private boolean isBackholeOperator;

    private boolean isGraderOperator;

    private boolean isMilingMachineOperator;

    private boolean isLoaderOperator;

    private boolean isBulldozerOperator;

    private boolean isCraneOperator;

    public WorkerDto(int id, String firstName, String lastName, float hourlyRate, float foremanAddition, boolean isStackerOperator, boolean isRollerOperator, boolean isExcavatorOperator, boolean isBackholeOperator, boolean isGraderOperator, boolean isMilingMachineOperator, boolean isLoaderOperator, boolean isBulldozerOperator, boolean isCraneOperator) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyRate = hourlyRate;
        this.foremanAddition = foremanAddition;
        this.isStackerOperator = isStackerOperator;
        this.isRollerOperator = isRollerOperator;
        this.isExcavatorOperator = isExcavatorOperator;
        this.isBackholeOperator = isBackholeOperator;
        this.isGraderOperator = isGraderOperator;
        this.isMilingMachineOperator = isMilingMachineOperator;
        this.isLoaderOperator = isLoaderOperator;
        this.isBulldozerOperator = isBulldozerOperator;
        this.isCraneOperator = isCraneOperator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
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
}
