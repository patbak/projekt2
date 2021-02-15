package com.example.projekt.service;

import com.example.projekt.model.*;
import com.example.projekt.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingCostsService {

    @Autowired
    private CostsJpaRepository costsJpaRepository;
    @Autowired
    private BuildingDailyReportsJpaRepository buildingDailyReportsJpaRepository;
    @Autowired
    private DailyWorkReportJpaRepository dailyWorkReportJpaRepository;
    @Autowired
    private DateConverterService dateConverterService;
    @Autowired
    private ConstructionSiteJpaRepository constructionSiteJpaRepository;
    @Autowired
    private HoursJpaRepository hoursJpaRepository;
    @Autowired
    private SalaryService salaryService;

    private Costs costs;
    private LocalDate endOfMonth = LocalDate.now().minusMonths(1).withDayOfMonth(LocalDate.now().minusMonths(1).lengthOfMonth());
    private LocalDate startOfMonth = endOfMonth.withDayOfMonth(1);
    private LocalDate todayDate=LocalDate.now();
    private List<Costs> costsList;

    public void countBuildingCosts(){
        costsList = new ArrayList<>();
        List<ConstructionSite> constructionSiteList = constructionSiteJpaRepository.findAllByIsActive(true);
        for (ConstructionSite constructionSite:constructionSiteList){
            costs = new Costs();
        countWorkersCosts(constructionSite);
        countMaterialCosts(constructionSite.getConstructionSiteId());
        countEquipmentCosts(constructionSite.getConstructionSiteId());
        costs.countmonthlyCost(costs.getWorkersCost(),costs.getEquipmentCost(), costs.getMaterialCost());
        costs.countTotalCosts(getLastTotalCost(constructionSite),costs.getMonthlyCost());
        costs.setDate(todayDate);
        costsList.add(costs);
        }
        costsJpaRepository.saveAll(costsList);
    }

    public void countEquipmentCosts(int id){
    List<BuildingDailyReports> buildingDailyReportsList = buildingDailyReportsJpaRepository.findAllByReportDateBetweenAndConstructionSite_ConstructionSiteId(
            dateConverterService.convertToDateViaSqlDate(startOfMonth),
            dateConverterService.convertToDateViaSqlDate(endOfMonth),
            id
    );
    for(BuildingDailyReports buildingDailyReports:buildingDailyReportsList){
        List<DailyMachineWorkReport> dailyMachineWorkReportList = buildingDailyReports.getDailyMachineWorkReports();
        for(DailyMachineWorkReport dailyMachineWorkReport:dailyMachineWorkReportList){
            List<MachineReportHasMachines> machineReportHasMachinesList = dailyMachineWorkReport.getMachineReportHasMachinesList();
            for(MachineReportHasMachines machineReportHasMachines : machineReportHasMachinesList){
               Machine machine = machineReportHasMachines.getMachine();
               costs.addEquipmentCost(machine.getAvgCosts()*machineReportHasMachines.getWorkHours());
            }
        }
    }
    }

      public void countMaterialCosts(int id){
        List<DailyWorkReport> dailyWorkReportList = dailyWorkReportJpaRepository.findAllByReportDateBetweenAndConstructionSite_ConstructionSiteId(
                dateConverterService.convertToDateViaSqlDate(startOfMonth), dateConverterService.convertToDateViaSqlDate(endOfMonth), id);

        for(DailyWorkReport dailyWorkReport:dailyWorkReportList){
            List<UsedMaterial> usedMaterials = dailyWorkReport.getUsedMaterials();
           for (UsedMaterial usedMaterial:usedMaterials){
                Material material = usedMaterial.getMaterial();
               costs.addMaterialCost(material.getAvgCost()*usedMaterial.getQuantity());
            }
        }

    }

    public void countWorkersCosts(ConstructionSite constructionSite){
        List<Hours> hoursList = hoursJpaRepository.findAllByDateBetweenAndConstructionSite_ConstructionSiteId(startOfMonth,endOfMonth, constructionSite.getConstructionSiteId());
        for(Hours hours:hoursList){
            Employee employee = hours.getEmployee();
            costs.addWorkerCosts(hours.getHours()*employee.getHourlyRate());
            costs.addWorkerCosts(hours.getHarmfulHours()*salaryService.HARMFUL_ALLOWANCE);
            costs.addWorkerCosts(hours.getOvertime()*employee.getHourlyRate()*salaryService.OVERTIME_ALLOWANCE);
            costs.addWorkerCosts(hours.getNightHours()*employee.getHourlyRate()*salaryService.NIGHT_ALLOWANCE);
            costs.setConstructionSite(constructionSite);
    }
    }

    public double getLastTotalCost(ConstructionSite constructionSite){
        List<Costs> costsList = costsJpaRepository.findAllByConstructionSite_ConstructionSiteIdOrderByDateDesc(constructionSite.getConstructionSiteId());
        Costs costs = costsList.get(0);
        return  costs.getTotalCost();
    }



}
