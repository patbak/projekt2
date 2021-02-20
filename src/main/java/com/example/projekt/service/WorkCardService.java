package com.example.projekt.service;

import com.example.projekt.entity.BrigadeDailyReportDto;
import com.example.projekt.entity.WorkCardCommandDto;
import com.example.projekt.entity.WorkCardDto;
import com.example.projekt.entity.WorkerDto;
import com.example.projekt.model.DailyWorkReport;
import com.example.projekt.model.Employee;
import com.example.projekt.model.Timesheet;
import com.example.projekt.repository.DailyWorkReportJpaRepository;
import com.example.projekt.repository.EmployeeJpaRepository;
import com.example.projekt.repository.TimesheetJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkCardService {

    @Autowired
    private TimesheetJpaRepository timesheetJpaRepository;
    @Autowired
    private  WorkerService workerService;
    @Autowired
    private BrigadeDailyReportService brigadeDailyReportService;
    @Autowired
    private DailyWorkReportJpaRepository dailyWorkReportJpaRepository;
    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    public List<WorkCardDto> getWorkCards(){
        List<Timesheet> timesheetList = timesheetJpaRepository.findAll();
        List<WorkCardDto> workCardDtoList = new ArrayList<>();

        for(Timesheet timesheet:timesheetList){
            WorkCardDto workCardDto = setWorkCard(timesheet);
            workCardDtoList.add(workCardDto);
        }
        return workCardDtoList;
    }

    public WorkCardDto setWorkCard(Timesheet timesheet){

        WorkerDto workerDto = workerService.setWorker(timesheet.getEmployee());
        BrigadeDailyReportDto brigadeDailyReportDto = brigadeDailyReportService.setBrigadeReport(timesheet.getDailyWorkReport());

        WorkCardDto workCardDto = new WorkCardDto(
                timesheet.getTimesheetId(),
                timesheet.getTimesheetDate(),
                timesheet.getHarmfulHours(),
                timesheet.getStartTimeOfWork(),
                timesheet.getEndTimeOfWork(),
                workerDto,
                brigadeDailyReportDto
        );
        return  workCardDto;
    }

    public void createWorkCard(int brigadeReportId, WorkCardCommandDto workCardCommandDto){

        DailyWorkReport dailyWorkReport = dailyWorkReportJpaRepository.getOne(brigadeReportId);
        Employee employee = employeeJpaRepository.getOne(workCardCommandDto.getWorkerId());
        Timesheet timesheet = new Timesheet();
        timesheet.setStartTimeOfWork(workCardCommandDto.getTimeOfBegin());
        timesheet.setEndTimeOfWork(workCardCommandDto.getTimeOfEnd());
        timesheet.setHarmfulHours(workCardCommandDto.getHarmfulHours());
        timesheet.setTimesheetDate(workCardCommandDto.getDateOfWork());
        timesheet.setEmployee(employee);
        timesheet.setDailyWorkReport(dailyWorkReport);

    timesheetJpaRepository.saveAndFlush(timesheet);
    }

    public void updateWorkCard( int workCardId, WorkCardCommandDto workCardCommandDto){

        Employee employee = employeeJpaRepository.getOne(workCardCommandDto.getWorkerId());
        Timesheet timesheet = timesheetJpaRepository.getOne(workCardId);
        timesheet.setStartTimeOfWork(workCardCommandDto.getTimeOfBegin());
        timesheet.setEndTimeOfWork(workCardCommandDto.getTimeOfEnd());
        timesheet.setTimesheetDate(workCardCommandDto.getDateOfWork());
        timesheet.setHarmfulHours(workCardCommandDto.getHarmfulHours());
        timesheet.setEmployee(employee);

        timesheetJpaRepository.saveAndFlush(timesheet);

    }


}
