package com.example.projekt.controller;

import com.example.projekt.dto.*;
import com.example.projekt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BrigadeDailyReportsController {

    @Autowired
    private BrigadeDailyReportService brigadeDailyReportService;
    @Autowired
    private WorkCardService workCardService;
    @Autowired
    private DoneWorkService doneWorkService;
    @Autowired
    private MaterialUsedService materialUsedService;


    @GetMapping("/brigade-daily-reports")
    public List<BrigadeDailyReportDto> getReports(){


        return brigadeDailyReportService.getBrigadeReports();
    }

    @GetMapping("/brigade-daily-reports/{id}")
    public BrigadeDailyReportDto getReportById(@PathVariable int id){

        return brigadeDailyReportService.getBrigadeReportById(id);
    }

    @GetMapping("/brigade-daily-reports/{id}/work-cards")
    public List<WorkCardDto> getReportsWorkCardsByReportId(@PathVariable int id){
        return brigadeDailyReportService.getReportsWorkCards(id);
    }

    @GetMapping("/brigade-daily-reports/{id}/done-works")
    public List<DoneWorkDto> getReportsDoneWorksByReportId(@PathVariable int id){
        return brigadeDailyReportService.getReportsDoneWorks(id);
    }

    @GetMapping("/brigade-daily-reports/{id}/materials-used")
    public List<MaterialUsedDto> getReportsMaterialsUsed(@PathVariable int id){
        return brigadeDailyReportService.getReportsMaterialUsed(id);
    }

    @PostMapping("/brigade-daily-reports/{id}/work-cards")
    public void createWorkCard(@PathVariable int id, @RequestBody WorkCardCommandDto workCardDto){
        workCardService.createWorkCard(id,workCardDto);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/brigade-daily-reports/{brigadeDailyReportId}/work-cards/{workCardId}")
    public void updateWorkCard(
            @PathVariable int brigadeDailyReportId,
            @PathVariable int workCardId,
            @RequestBody WorkCardCommandDto workCardCommandDto ){
        workCardService.updateWorkCard(workCardId, workCardCommandDto);
    }

    @PostMapping("/brigade-daily-reports/{id}/done-works")
    public void createDoneWork(@PathVariable int id, @RequestBody DoneWorkCommandDto doneWorkCommandDto){
        doneWorkService.createDoneWork(id,doneWorkCommandDto);

    }

    @PostMapping("/brigade-daily-reports/{brigadeDailyReportId}/done-works/{doneWorkId}")
    public void updateDoneWork(
            @PathVariable int brigadeDailyReportId,
            @PathVariable int doneWorkId,
            @RequestBody DoneWorkCommandDto doneWorkCommandDto
            ){
        doneWorkService.updateDoneWork(doneWorkCommandDto,doneWorkId);

    }

    @PostMapping("/brigade-daily-reports/{brigadeDailyReportId}/materials-used")
    public void createUsedMaterial(@PathVariable int brigadeDailyReportId, @RequestBody MaterialUsedCommandDto materialUsedCommandDto){
        materialUsedService.createMaterialUsed(brigadeDailyReportId,materialUsedCommandDto);

    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/brigade-daily-reports/{brigadeDailyReportId}/materials-used/{materialUsedId}")
    public void createUsedMaterial(
            @PathVariable int brigadeDailyReportId,
            @PathVariable int materialUsedId,
            @RequestBody MaterialUsedCommandDto materialUsedCommandDto){
        materialUsedService.updateMaterialUsed(brigadeDailyReportId,materialUsedId,materialUsedCommandDto);
    }


}
