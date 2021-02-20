package com.example.projekt.service;

import com.example.projekt.entity.EquipmentDailyReportDto;
import com.example.projekt.entity.OperatorWorkCardCommandDto;
import com.example.projekt.entity.OperatorWorkCardDto;
import com.example.projekt.entity.WorkerDto;
import com.example.projekt.model.DailyMachineWorkReport;
import com.example.projekt.model.Employee;
import com.example.projekt.model.OperatorWorkCards;
import com.example.projekt.repository.DailyMachineWorkReportJpaRepository;
import com.example.projekt.repository.EmployeeJpaRepository;
import com.example.projekt.repository.OperatorWorkCardsJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperatorWorkCardsService {

    @Autowired
    private OperatorWorkCardsJpaRepository operatorWorkCardsJpaRepository;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private EquipmentDailyReportService equipmentDailyReportService;
    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;
    @Autowired
    private DailyMachineWorkReportJpaRepository dailyMachineWorkReportJpaRepository;

    public List<OperatorWorkCardDto> getOperatorWorkCards(){
        List<OperatorWorkCards> operatorWorkCards = operatorWorkCardsJpaRepository.findAll();
        List<OperatorWorkCardDto> operatorWorkCardDtoList = new ArrayList<>();
        for(OperatorWorkCards operatorWorkCard:operatorWorkCards){
            OperatorWorkCardDto operatorWorkCardDto = setOperatorCard(operatorWorkCard);
            operatorWorkCardDtoList.add(operatorWorkCardDto);
        }
        return operatorWorkCardDtoList;
    }

    public OperatorWorkCardDto setOperatorCard(OperatorWorkCards operatorWorkCards){
        WorkerDto workerDto = workerService.setWorker(operatorWorkCards.getEmployee());
        EquipmentDailyReportDto equipmentDailyReportDto = equipmentDailyReportService.setEquipmentReport(operatorWorkCards.getDailyMachineWorkReport());
          OperatorWorkCardDto operatorWorkCardDto = new OperatorWorkCardDto(
                  operatorWorkCards.getIdWorkCard(),
                  operatorWorkCards.getWorkCardDate(),
                  operatorWorkCards.getHarmfulHours(),
                  operatorWorkCards.getStartTimeOfWork(),
                  operatorWorkCards.getEndTimeOfWork(),
                  workerDto,
                  equipmentDailyReportDto
          );
    return operatorWorkCardDto;
    }

    public void createOperatorWorkCard(int  dailyReportId, OperatorWorkCardCommandDto operatorWorkCardCommandDto){
        DailyMachineWorkReport dailyMachineWorkReport = dailyMachineWorkReportJpaRepository.getOne(dailyReportId);
        Employee employee = employeeJpaRepository.getOne(operatorWorkCardCommandDto.getWorkerId());
        OperatorWorkCards operatorWorkCards = new OperatorWorkCards(
                operatorWorkCardCommandDto.getDateOfWorkCard(),
                operatorWorkCardCommandDto.getTimeOfBegin(),
                operatorWorkCardCommandDto.getTimeOfEnd(),
                operatorWorkCardCommandDto.getHarmfulHours(),
                employee,
                dailyMachineWorkReport
        );
        operatorWorkCardsJpaRepository.saveAndFlush(operatorWorkCards);
    }

    public void updateOperatorWorkCard(int operatorWorkCardId, OperatorWorkCardCommandDto operatorWorkCardCommandDto){
        OperatorWorkCards operatorWorkCards = operatorWorkCardsJpaRepository.getOne(operatorWorkCardId);
        Employee employee = employeeJpaRepository.getOne(operatorWorkCardCommandDto.getWorkerId());
        operatorWorkCards.setWorkCardDate(operatorWorkCardCommandDto.getDateOfWorkCard());
        operatorWorkCards.setEmployee(employee);
        operatorWorkCards.setStartTimeOfWork(operatorWorkCardCommandDto.getTimeOfBegin());
        operatorWorkCards.setEndTimeOfWork(operatorWorkCardCommandDto.getTimeOfEnd());
        operatorWorkCards.setHarmfulHours(operatorWorkCardCommandDto.getHarmfulHours());
        operatorWorkCardsJpaRepository.saveAndFlush(operatorWorkCards);
    }
}
