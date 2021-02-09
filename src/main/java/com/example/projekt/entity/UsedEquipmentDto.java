package com.example.projekt.entity;

import com.example.projekt.model.Machine;

public class UsedEquipmentDto {

    private MachineDto machine;

    private WorkerDto worker;

    public UsedEquipmentDto(MachineDto machine, WorkerDto worker) {
        this.machine = machine;
        this.worker = worker;
    }

    public MachineDto getMachine() {
        return machine;
    }

    public void setMachine(MachineDto machine) {
        this.machine = machine;
    }

    public WorkerDto getWorker() {
        return worker;
    }

    public void setWorker(WorkerDto worker) {
        this.worker = worker;
    }
}
