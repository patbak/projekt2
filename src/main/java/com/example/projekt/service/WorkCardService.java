package com.example.projekt.service;

import com.example.projekt.entity.BrigadeDailyReportDto;
import com.example.projekt.entity.WorkCardDto;
import com.example.projekt.entity.WorkerDto;
import com.example.projekt.model.Timesheet;
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

}
