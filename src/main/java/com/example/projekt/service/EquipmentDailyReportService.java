package com.example.projekt.service;

import com.example.projekt.entity.*;
import com.example.projekt.model.*;
import com.example.projekt.repository.BuildingDailyReportsJpaRepository;
import com.example.projekt.repository.DailyMachineWorkReportJpaRepository;
import com.example.projekt.repository.DailyWorkReportJpaRepository;
import com.example.projekt.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
   private WorkerService workerService;
   @Autowired
   private UsedEquipmentService usedEquipmentService;
   @Autowired
   private OperatorWorkCardsService operatorWorkCardsService;
   @Autowired
   private BuildingDailyReportsJpaRepository buildingDailyReportsJpaRepository;
   @Autowired
   private UserJpaRepository userJpaRepository;
   @Autowired
   private DailyWorkReportJpaRepository dailyWorkReportJpaRepository;

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
        EquipmentDailyReportDto equipmentDailyReportDto = new EquipmentDailyReportDto(
                dailyMachineWorkReport.getDailyMachineWorkReportId(),
                buildingDailyReportsDto,
                dailyMachineWorkReport.getReportDate(),
                engineer,
                dailyMachineWorkReport.getReportNumber(),
                dailyMachineWorkReport.getTask()
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

    public EquipmentDailyReportDto getEquipmentDailyReportById(int id){
        DailyMachineWorkReport dailyMachineWorkReport = dailyMachineWorkReportJpaRepository.getOne(id);
        EquipmentDailyReportDto equipmentDailyReportDto = setEquipmentReport(dailyMachineWorkReport);
        return equipmentDailyReportDto;
    }

    public List<UsedEquipmentDto> getUsedEquipmentByEquipmentReport(int id){
        DailyMachineWorkReport dailyMachineWorkReport = dailyMachineWorkReportJpaRepository.getOne(id);
        List<MachineReportHasMachines> machineReportHasMachinesList =  dailyMachineWorkReport.getMachineReportHasMachinesList();
        List<UsedEquipmentDto> usedEquipmentDtoList = new ArrayList<>();
        for(MachineReportHasMachines machineReportHasMachines:machineReportHasMachinesList){
            UsedEquipmentDto usedEquipmentDto = usedEquipmentService.setUsedEquipment(machineReportHasMachines);
            usedEquipmentDtoList.add(usedEquipmentDto);
        }
        return usedEquipmentDtoList;
    }

    public List<OperatorWorkCardDto> getOperatorWorkCardsByEquipmentReport(int id){
        DailyMachineWorkReport dailyMachineWorkReport = dailyMachineWorkReportJpaRepository.getOne(id);
        List<OperatorWorkCards> operatorWorkCardsList =  dailyMachineWorkReport.getOperatorWorkCards();
        List<OperatorWorkCardDto> operatorWorkCardDtoList = new ArrayList<>();
        for(OperatorWorkCards operatorWorkCards:operatorWorkCardsList){
            OperatorWorkCardDto operatorWorkCardDto = operatorWorkCardsService.setOperatorCard(operatorWorkCards);
            operatorWorkCardDtoList.add(operatorWorkCardDto);
        }
        return operatorWorkCardDtoList;
    }

    public void createEquipmentDailyReport(int id){
        BuildingDailyReports buildingDailyReports = buildingDailyReportsJpaRepository.getOne(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userJpaRepository.findByLogin(authentication.getName());
        DailyMachineWorkReport dailyMachineWorkReport = new DailyMachineWorkReport(buildingDailyReports.getReportDate(), buildingDailyReports, user);
        dailyMachineWorkReportJpaRepository.saveAndFlush(dailyMachineWorkReport);
    }

}
