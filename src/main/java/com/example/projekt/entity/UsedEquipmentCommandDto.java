package com.example.projekt.entity;

public class UsedEquipmentCommandDto {
    private int machineId;
    private int workerId;

    public UsedEquipmentCommandDto(int machineId, int workerId) {
        this.machineId = machineId;
        this.workerId = workerId;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }
}
