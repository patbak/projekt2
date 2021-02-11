package com.example.projekt.controller;

import com.example.projekt.entity.CommentsDto;
import com.example.projekt.entity.EquipmentDailyReportDto;
import com.example.projekt.service.CommentService;
import com.example.projekt.service.EquipmentDailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class EquipmentDailyReportsController {

    @Autowired
    private EquipmentDailyReportService equipmentDailyReportService;

    @GetMapping("/EquipmentReports")
    public List<EquipmentDailyReportDto> getEquipmentReports(){

        List<EquipmentDailyReportDto> equipmentDailyReportDtoList = equipmentDailyReportService.getEquipmentReports() ;
        return equipmentDailyReportDtoList;
    }

}
