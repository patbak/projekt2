package com.example.projekt.controller;

import com.example.projekt.entity.*;
import com.example.projekt.service.BrigadeDailyReportService;
import com.example.projekt.service.BuildingDailyReportDtoService;
import com.example.projekt.service.CommentService;
import com.example.projekt.service.EquipmentDailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class BuildingDailyReportController {

    @Autowired
    private BuildingDailyReportDtoService buildingDailyReportDtoService;
    @Autowired
    private BrigadeDailyReportService brigadeDailyReportService;
    @Autowired
    private EquipmentDailyReportService equipmentDailyReportService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/daily-reports/{id}")
    public BuildingDailyReportsDto getBuildingDailyReport(@PathVariable int id){
        return buildingDailyReportDtoService.getBuildingDailyReport(id);
    }

    @PostMapping("/daily-reports")
    public void createDailyReport(@RequestBody DailyReportCommandDto dailyReportCommandDto){
        buildingDailyReportDtoService.createBuildingReport(dailyReportCommandDto);
    }

    @GetMapping("/daily-reports/{id}/comments")
    public List<CommentsDto> getBuildingDailyReportComments(@PathVariable int id){
        return buildingDailyReportDtoService.getBuildingDailyReportComments(id);
    }

    @GetMapping("/daily-reports/{id}/equipment-daily-reports")
    public List<EquipmentDailyReportDto> getBuildingDailyReportEquipmentReports(@PathVariable int id){
        return buildingDailyReportDtoService.getEquipmentReportsByDailyReportId(id);
    }

    @GetMapping("/daily-reports/{id}/brigade-daily-reports")
    public List<BrigadeDailyReportDto> getBuildingDailyReportBrigadeReports(@PathVariable int id){
        return buildingDailyReportDtoService.getBrigadeReportsByBuildingReports(id);
    }

    @PostMapping("/daily-reports/{id}/brigade-daily-reports")
    public void createBrigadeDailyReport(@PathVariable int id){
        brigadeDailyReportService.createBrigadeDailyReport(id);
    }

    @PostMapping("/daily-reports/{id}/equipment-daily-reports")
    public void createEquipmentDailyReport(@PathVariable int id){
        equipmentDailyReportService.createEquipmentDailyReport(id);
    }

    @PostMapping("/daily-reports/{id}/comments")
    public void createComment(@PathVariable int id, @RequestBody CommentsCommandDto commentsCommandDto){
        commentService.createComment(id, commentsCommandDto);
    }


}
