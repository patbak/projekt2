package com.example.projekt.service;

import com.example.projekt.entity.*;
import com.example.projekt.model.*;
import com.example.projekt.repository.BuildingDailyReportsJpaRepository;
import com.example.projekt.repository.DailyWorkReportJpaRepository;
import com.example.projekt.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BrigadeDailyReportService {

    @Autowired
    private DailyWorkReportJpaRepository jpaRepository;
    @Autowired
    private BuildingDailyReportDtoService buildingDailyReportDtoService;
    @Autowired
    private EngineerService engineerService;
    @Autowired
    private WorkCardService workCardService;
    @Autowired
    private DoneWorkService doneWorkService;
    @Autowired
    private MaterialUsedService materialUsedService;
    @Autowired
    private DailyWorkReportJpaRepository dailyWorkReportJpaRepository;
    @Autowired
    private BuildingDailyReportsJpaRepository buildingDailyReportsJpaRepository;
    @Autowired
    private UserJpaRepository userJpaRepository;

    public List<BrigadeDailyReportDto> getBrigadeReports(){
        List<DailyWorkReport> dailyWorkReports = jpaRepository.findAll();
        List<BrigadeDailyReportDto> brigadeDailyReportDtoList = new ArrayList<>();
        for (DailyWorkReport dailyWorkReport:dailyWorkReports){
            Engineer engineer = engineerService.setEngineer(dailyWorkReport.getUser());
            BuildingDailyReportsDto buildingDailyReportsDto = buildingDailyReportDtoService.setBuildingReport(dailyWorkReport.getBuildingDailyReports());
            BrigadeDailyReportDto brigadeDailyReportDto = new BrigadeDailyReportDto(
                    dailyWorkReport.getDailyWorkReportId(),
                    dailyWorkReport.getReportDate(),
                    dailyWorkReport.getReportNumber(),
                    engineer,
                    buildingDailyReportsDto
                    );
            brigadeDailyReportDtoList.add(brigadeDailyReportDto);

        }
        return brigadeDailyReportDtoList;

    }

    public BrigadeDailyReportDto setBrigadeReport(DailyWorkReport dailyWorkReport){
        Engineer engineer = engineerService.setEngineer(dailyWorkReport.getUser());
        BuildingDailyReportsDto buildingDailyReportsDto = buildingDailyReportDtoService.setBuildingReport(dailyWorkReport.getBuildingDailyReports());
        BrigadeDailyReportDto brigadeDailyReportDto = new BrigadeDailyReportDto(
                dailyWorkReport.getDailyWorkReportId(),
                dailyWorkReport.getReportDate(),
                dailyWorkReport.getReportNumber(),
                engineer,
                buildingDailyReportsDto
        );
        return brigadeDailyReportDto;
    }

    public BrigadeDailyReportDto getBrigadeReportById(int id){
        DailyWorkReport dailyWorkReport = jpaRepository.getOne(id);
        BrigadeDailyReportDto brigadeDailyReportDto = setBrigadeReport(dailyWorkReport);
        return brigadeDailyReportDto;
    }

    public List<WorkCardDto> getReportsWorkCards(int id){
        DailyWorkReport dailyWorkReport = jpaRepository.getOne(id);
        List<Timesheet> timesheets = dailyWorkReport.getTimesheets();
        List<WorkCardDto> workCardDtoList = new ArrayList<>();
        for(Timesheet timesheet:timesheets){
            WorkCardDto workCardDto = workCardService.setWorkCard(timesheet);
            workCardDtoList.add(workCardDto);
        }
        return workCardDtoList;
    }

    public List<DoneWorkDto> getReportsDoneWorks(int id){
        DailyWorkReport dailyWorkReport = jpaRepository.getOne(id);
        List<WorkDone> workDoneList = dailyWorkReport.getWorksDone();
        List<DoneWorkDto> doneWorkDtoList = new ArrayList<>();
        for(WorkDone workDone:workDoneList){
           DoneWorkDto doneWorkDto = doneWorkService.setDoneWork(workDone);
           doneWorkDtoList.add(doneWorkDto);
        }
        return doneWorkDtoList;
    }

    public List<MaterialUsedDto> getReportsMaterialUsed(int id){
        DailyWorkReport dailyWorkReport = jpaRepository.getOne(id);
        List<UsedMaterial> usedMaterials = dailyWorkReport.getUsedMaterials();
        List<MaterialUsedDto> materialUsedDtoList = new ArrayList<>();
        for(UsedMaterial usedMaterial:usedMaterials){
            MaterialUsedDto materialUsedDto = materialUsedService.setMaterialUsed(usedMaterial);
            materialUsedDtoList.add(materialUsedDto);
        }
        return materialUsedDtoList;
    }


    public void createBrigadeDailyReport(int id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userJpaRepository.findByLogin(authentication.getName());
        BuildingDailyReports buildingDailyReports = buildingDailyReportsJpaRepository.getOne(id);
        ConstructionSite constructionSite = buildingDailyReports.getConstructionSite();
        DailyWorkReport dailyWorkReport = new DailyWorkReport(buildingDailyReports.getReportDate(), user,constructionSite, buildingDailyReports );
        dailyWorkReportJpaRepository.saveAndFlush(dailyWorkReport);
    }




}
