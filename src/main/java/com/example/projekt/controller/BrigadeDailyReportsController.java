package com.example.projekt.controller;

import com.example.projekt.entity.*;
import com.example.projekt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<String> createWorkCard(@PathVariable int id, @RequestBody WorkCardCommandDto workCardDto){
        workCardService.createWorkCard(id,workCardDto);
        return new ResponseEntity<>("Dodano karte pracy.", HttpStatus.CREATED);
    }

    @PutMapping("/brigade-daily-reports/{brigadeDailyReportId}/work-cards/{workCardId}")
    public ResponseEntity<String> updateWorkCard(
            @PathVariable int brigadeDailyReportId,
            @PathVariable int workCardId,
            @RequestBody WorkCardCommandDto workCardCommandDto ){
        workCardService.updateWorkCard(workCardId, workCardCommandDto);
        return new ResponseEntity<>("Zaktualizowano karte pracy.", HttpStatus.OK);
    }

    @PostMapping("/brigade-daily-reports/{id}/done-works")
    public ResponseEntity<String> createDoneWork(@PathVariable int id, @RequestBody DoneWorkCommandDto doneWorkCommandDto){
        doneWorkService.createDoneWork(id,doneWorkCommandDto);
        return new ResponseEntity<>("Dodano wykonaną robotę.", HttpStatus.CREATED);
    }

    @PostMapping("/brigade-daily-reports/{brigadeDailyReportId}/done-works/{doneWorkId}")
    public ResponseEntity<String> updateDoneWork(
            @PathVariable int brigadeDailyReportId,
            @PathVariable int doneWorkId,
            @RequestBody DoneWorkCommandDto doneWorkCommandDto
            ){
        doneWorkService.updateDoneWork(doneWorkCommandDto,doneWorkId);
        return new ResponseEntity<>("Zaktualizowano wykonaną robotę.", HttpStatus.OK);
    }

    @PostMapping("/brigade-daily-reports/{brigadeDailyReportId}/materials-used")
    public ResponseEntity<String> createUsedMaterial(@PathVariable int brigadeDailyReportId, @RequestBody MaterialUsedCommandDto materialUsedCommandDto){
        materialUsedService.createMaterialUsed(brigadeDailyReportId,materialUsedCommandDto);
        return new ResponseEntity<>("Dodano zużyty materiał.", HttpStatus.CREATED);
    }

    @PutMapping("/brigade-daily-reports/{brigadeDailyReportId}/materials-used/{materialUsedId}")
    public ResponseEntity<String> createUsedMaterial(
            @PathVariable int brigadeDailyReportId,
            @PathVariable int materialUsedId,
            @RequestBody MaterialUsedCommandDto materialUsedCommandDto){
        materialUsedService.updateMaterialUsed(brigadeDailyReportId,materialUsedId,materialUsedCommandDto);
        return new ResponseEntity<>("Zaktualizowano zużyty materiał.", HttpStatus.OK);
    }


}
