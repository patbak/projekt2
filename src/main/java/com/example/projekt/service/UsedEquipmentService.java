package com.example.projekt.service;

import com.example.projekt.entity.MachineDto;
import com.example.projekt.entity.UsedEquipmentDto;
import com.example.projekt.entity.WorkerDto;
import com.example.projekt.model.Machine;
import com.example.projekt.model.MachineReportHasMachines;
import com.example.projekt.repository.MachineReportHasMachinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsedEquipmentService {

    @Autowired
    private MachineReportHasMachinesRepository machineReportHasMachinesRepository;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private MachineService machineService;

    public List<UsedEquipmentDto> getUsedEquipment(){
        List<MachineReportHasMachines> machineReportHasMachinesList = machineReportHasMachinesRepository.findAll();
        List<UsedEquipmentDto> usedEquipmentDtoList = new ArrayList<>();
        for(MachineReportHasMachines machineReportHasMachine:machineReportHasMachinesList){
        UsedEquipmentDto usedEquipmentDto = setUsedEquipment(machineReportHasMachine);
        usedEquipmentDtoList.add(usedEquipmentDto);
        }
        return usedEquipmentDtoList;
    }

    public UsedEquipmentDto setUsedEquipment(MachineReportHasMachines machineReportHasMachines){
        MachineDto machineDto = machineService.setMachine(machineReportHasMachines.getMachine());
        WorkerDto workerDto = workerService.setWorker(machineReportHasMachines.getEmployee());
        UsedEquipmentDto usedEquipmentDto = new UsedEquipmentDto(
               machineDto,
                workerDto
        );
        return  usedEquipmentDto;
    }

}
