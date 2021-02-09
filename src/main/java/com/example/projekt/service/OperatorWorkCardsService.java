package com.example.projekt.service;

import com.example.projekt.entity.EquipmentDailyReportDto;
import com.example.projekt.entity.OperatorWorkCardDto;
import com.example.projekt.entity.WorkerDto;
import com.example.projekt.model.OperatorWorkCards;
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

}
