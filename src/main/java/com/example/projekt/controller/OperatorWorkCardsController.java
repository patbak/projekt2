package com.example.projekt.controller;

import com.example.projekt.entity.BuildingDailyReportsDto;
import com.example.projekt.entity.OperatorWorkCardDto;
import com.example.projekt.service.BuildingDailyReportDtoService;
import com.example.projekt.service.OperatorWorkCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OperatorWorkCardsController {

    @Autowired
    private OperatorWorkCardsService operatorWorkCardsService;

    @GetMapping("/operator-work-cards")
    public List<OperatorWorkCardDto> getOperatorWorkCards(){
        return operatorWorkCardsService.getOperatorWorkCards();
    }

}
