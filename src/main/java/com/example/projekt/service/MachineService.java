package com.example.projekt.service;

import com.example.projekt.entity.MachineDto;
import com.example.projekt.model.Machine;
import com.example.projekt.model.MachineReportHasMachines;
import com.example.projekt.repository.MachineJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MachineService {

    @Autowired
    private MachineJpaRepository machineJpaRepository;

    public List<MachineDto> getMachines(){

        List<Machine> machineList = machineJpaRepository.findAll();
        List<MachineDto> machineDtoList = new ArrayList<>();
        for(Machine machine:machineList){
            MachineDto machineDto = setMachine(machine);
            machineDtoList.add(machineDto);
        }
        return machineDtoList;
    }

    public MachineDto setMachine(Machine machine){
        MachineDto machineDto = new MachineDto(
                machine.getMachineId(),
                machine.getMachineName(),
                machine.getInventoryNumber(),
                machine.getPowerHP(),
                machine.getFuelConsumption(),
                machine.getFuelTankCapacity(),
                machine.getYearOfProduction().toLocalDate().getYear(),
                machine.getComments()

        );
        return machineDto;
    }

    public List<MachineDto> setMachineList(List<MachineReportHasMachines> machines){
        List<MachineDto> machineDtoList = new ArrayList<>();

        for (MachineReportHasMachines machineReportHasMachines:machines){
            Machine machine = machineReportHasMachines.getMachine();
            MachineDto  machineDto = setMachine(machine);
            machineDtoList.add(machineDto);
        }
        return  machineDtoList;
    }

}
