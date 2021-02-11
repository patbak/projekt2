package com.example.projekt.controller;

import com.example.projekt.entity.BuildingDailyReportsDto;
import com.example.projekt.entity.OperatorWorkCardDto;
import com.example.projekt.service.BuildingDailyReportDtoService;
import com.example.projekt.service.OperatorWorkCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperatorWorkCardsController {

    @Autowired
    private OperatorWorkCardsService operatorWorkCardsService;

    @GetMapping("/OperatorWorkCards")
    public List<OperatorWorkCardDto> getOperatorWorkCards(){

        List<OperatorWorkCardDto> operatorWorkCardDtoList = operatorWorkCardsService.getOperatorWorkCards();
        return operatorWorkCardDtoList;
    }

}
