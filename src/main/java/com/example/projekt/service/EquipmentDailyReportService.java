package com.example.projekt.service;

import com.example.projekt.entity.*;
import com.example.projekt.model.DailyMachineWorkReport;
import com.example.projekt.model.Employee;
import com.example.projekt.model.OperatorWorkCards;
import com.example.projekt.repository.DailyMachineWorkReportJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentDailyReportService {

    @Autowired
    private DailyMachineWorkReportJpaRepository dailyMachineWorkReportJpaRepository;

   @Autowired
   private BuildingDailyReportDtoService buildingDailyReportDtoService;
   @Autowired
    private EngineerService engineerService;
   @Autowired
   private MachineService machineService;
   @Autowired
   private WorkerService workerService;
    public List<EquipmentDailyReportDto> getEquipmentReports(){

        List<DailyMachineWorkReport> dailyMachineWorkReports = dailyMachineWorkReportJpaRepository.findAll();
        List<EquipmentDailyReportDto> equipmentDailyReportDtoList = new ArrayList<>();
        for(DailyMachineWorkReport dailyMachineWorkReport:dailyMachineWorkReports){
            EquipmentDailyReportDto equipmentDailyReportDto = setEquipmentReport(dailyMachineWorkReport);
            equipmentDailyReportDtoList.add(equipmentDailyReportDto);
        }
        return equipmentDailyReportDtoList;
    }

    public EquipmentDailyReportDto setEquipmentReport(DailyMachineWorkReport dailyMachineWorkReport){

        BuildingDailyReportsDto buildingDailyReportsDto = buildingDailyReportDtoService.setBuildingReport(dailyMachineWorkReport.getBuildingDailyReports());
        Engineer engineer = engineerService.setEngineer(dailyMachineWorkReport.getUser());
        List<MachineDto> machineDtoList = machineService.setMachineList(dailyMachineWorkReport.getMachineReportHasMachinesList());
        EquipmentDailyReportDto equipmentDailyReportDto = new EquipmentDailyReportDto(
                dailyMachineWorkReport.getDailyMachineWorkReportId(),
                buildingDailyReportsDto,
                dailyMachineWorkReport.getReportDate(),
                engineer,
                dailyMachineWorkReport.getReportNumber(),
                dailyMachineWorkReport.getTask(),
                machineDtoList,
                getWorkersFromOperatorCards(dailyMachineWorkReport.getOperatorWorkCards())
        );
        return equipmentDailyReportDto;
    }


    public List<WorkerDto> getWorkersFromOperatorCards(List<OperatorWorkCards> operatorWorkCards){

        List<WorkerDto> workerDtoList = new ArrayList<>();
        for(OperatorWorkCards operatorWorkCard:operatorWorkCards){
            Employee employee = operatorWorkCard.getEmployee();
            WorkerDto workerDto = workerService.setWorker(employee);
            workerDtoList.add(workerDto);
        }
        return workerDtoList;
    }

}
