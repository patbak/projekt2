package com.example.projekt.entity;

import com.example.projekt.model.Machine;

public class UsedEquipmentDto {
    private int id;

    private MachineDto machine;

    private WorkerDto worker;

    public UsedEquipmentDto(int id, MachineDto machine, WorkerDto worker) {
        this.id = id;
        this.machine = machine;
        this.worker = worker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
