package com.example.projekt.service;

import com.example.projekt.entity.*;
import com.example.projekt.model.*;
import com.example.projekt.repository.DailyMachineWorkReportJpaRepository;
import com.example.projekt.repository.EmployeeJpaRepository;
import com.example.projekt.repository.MachineJpaRepository;
import com.example.projekt.repository.MachineReportHasMachinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    @Autowired
    private MachineJpaRepository machineJpaRepository;
    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;
    @Autowired
    private DailyMachineWorkReportJpaRepository dailyMachineWorkReportJpaRepository;

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
                machineReportHasMachines.getHasMachineId(),
               machineDto,
                workerDto
        );
        return  usedEquipmentDto;
    }

    public void createUsedEquipment(int id, UsedEquipmentCommandDto usedEquipmentCommandDto){
        Employee employee = employeeJpaRepository.getOne(usedEquipmentCommandDto.getWorkerId());
        Machine machine = machineJpaRepository.getOne(usedEquipmentCommandDto.getMachineId());
        DailyMachineWorkReport dailyMachineWorkReport = dailyMachineWorkReportJpaRepository.getOne(id);
        MachineReportHasMachines machineReportHasMachines = new MachineReportHasMachines(dailyMachineWorkReport, machine, employee);
        machineReportHasMachinesRepository.saveAndFlush(machineReportHasMachines);
    }

    public void updateUsedEquipment( int usedEquipmentId, UsedEquipmentCommandDto usedEquipmentCommandDto){
        MachineReportHasMachines machineReportHasMachines = machineReportHasMachinesRepository.getOne(usedEquipmentId);
        Employee employee = employeeJpaRepository.getOne(usedEquipmentCommandDto.getWorkerId());
        Machine machine = machineJpaRepository.getOne(usedEquipmentCommandDto.getMachineId());
        machineReportHasMachines.setEmployee(employee);
        machineReportHasMachines.setMachine(machine);
        machineReportHasMachinesRepository.saveAndFlush(machineReportHasMachines);
    }



}
