package com.example.projekt.controller;

import com.example.projekt.entity.*;
import com.example.projekt.service.CommentService;
import com.example.projekt.service.EquipmentDailyReportService;
import com.example.projekt.service.OperatorWorkCardsService;
import com.example.projekt.service.UsedEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class EquipmentDailyReportsController {

    @Autowired
    private EquipmentDailyReportService equipmentDailyReportService;
    @Autowired
    private UsedEquipmentService usedEquipmentService;
    @Autowired
    private OperatorWorkCardsService operatorWorkCardsService;

    @GetMapping("/equipment-daily-reports")
    public List<EquipmentDailyReportDto> getEquipmentReports(){

        List<EquipmentDailyReportDto> equipmentDailyReportDtoList = equipmentDailyReportService.getEquipmentReports() ;
        return equipmentDailyReportDtoList;
    }

    @GetMapping("/equipment-daily-reports/{id}")
    public EquipmentDailyReportDto getEquipmentReportById(@PathVariable int id){

        return equipmentDailyReportService.getEquipmentDailyReportById(id);
    }


    @GetMapping("/equipment-daily-reports/{id}/used-equipments")
    public List<UsedEquipmentDto> getUsedEquipment(@PathVariable int id){

        return equipmentDailyReportService.getUsedEquipmentByEquipmentReport(id);
    }

    @GetMapping("/equipment-daily-reports/{id}/operators-work-cards")
    public List<OperatorWorkCardDto> getOperatorWorkCardsByEquipmentReport(@PathVariable int id){

        return equipmentDailyReportService.getOperatorWorkCardsByEquipmentReport(id);
    }

    @PostMapping("/equipment-daily-reports/{id}/used-equipments")
    public void createUsedMaterial(@PathVariable int id, @RequestBody UsedEquipmentCommandDto usedEquipmentCommandDto){
    usedEquipmentService.createUsedEquipment(id, usedEquipmentCommandDto);
    }

    @PutMapping("/equipment-daily-reports/{dailyReportId}/used-equipments/{usedEquipmentId}")
    public void updateUsedMaterial(
            @PathVariable int dailyReportId,
            @PathVariable int usedEquipmentId,
            @RequestBody UsedEquipmentCommandDto usedEquipmentCommandDto){
            usedEquipmentService.updateUsedEquipment(usedEquipmentId, usedEquipmentCommandDto);
    }

    @PostMapping("/equipment-daily-reports/{dailyReportId}/operators-work-cards")
    public void createWorkCard(@PathVariable int dailyReportId, @RequestBody OperatorWorkCardCommandDto operatorWorkCardCommandDto){
        operatorWorkCardsService.createOperatorWorkCard(dailyReportId, operatorWorkCardCommandDto);
    }

    @PutMapping("/equipment-daily-reports/{dailyReportId}/operators-work-cards/{operatorWorkCardId}")
    public void updateWorkCard(
            @PathVariable int dailyReportId,
            @PathVariable int operatorWorkCardId,
            @RequestBody OperatorWorkCardCommandDto operatorWorkCardCommandDto){
        operatorWorkCardsService.updateOperatorWorkCard(operatorWorkCardId, operatorWorkCardCommandDto);
    }

}
