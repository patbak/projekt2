package com.example.projekt.controller;

import com.example.projekt.entity.CommentsDto;
import com.example.projekt.entity.EquipmentDailyReportDto;
import com.example.projekt.entity.OperatorWorkCardDto;
import com.example.projekt.entity.UsedEquipmentDto;
import com.example.projekt.service.CommentService;
import com.example.projekt.service.EquipmentDailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api")
public class EquipmentDailyReportsController {

    @Autowired
    private EquipmentDailyReportService equipmentDailyReportService;

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

}
