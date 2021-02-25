package com.example.projekt.controller;

import com.example.projekt.dto.*;
import com.example.projekt.service.BuildingDailyReportDtoService;
import com.example.projekt.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;
    @Autowired
    private BuildingDailyReportDtoService buildingDailyReportDtoService;

    @GetMapping("/buildings")
    public List<BuildingDto> getBuildings(){

    List<BuildingDto> buildingDtoList = buildingService.getBuildings();
    return buildingDtoList;
    }

    @GetMapping("/buildings/{id}")
    public BuildingDto getBuildings(@PathVariable int id){
        return buildingService.getBuildingById(id);
    }

    @PostMapping("/buildings")
    public void postBuilding(@RequestBody BuildingCommandDto buildingCommandDto){
        buildingService.saveBuilding(buildingCommandDto);
    }

    @GetMapping("/buildings/{id}/engineers")
    public List<Engineer> getEngineersOnBuilding(@PathVariable int id){
        return buildingService.getEngineersFromBuilding(id);
    }

    @GetMapping("/buildings/finished")
    public List<BuildingDto> getFinishedBuildings(){

        return buildingService.getBuildingsByActive(false);
    }

    @GetMapping("/buildings/active")
    public List<BuildingDto> getActiveBuildings(){
        return buildingService.getBuildingsByActive(true);
    }

    @PostMapping("/buildings/{id}/engineers")
    public void addEngineersToBuilding(@PathVariable int id, @RequestBody EngineerCommandDto engineerCommandDto){
        buildingService.addEngineerToBuilding(id, engineerCommandDto);
    }

    @GetMapping("/buildings/{id}/daily-reports")
    public List<BuildingDailyReportsDto> getDailyReportsFromBuilding(@PathVariable int id){

      return  buildingService.getBuildingReports(id);
    }

    @PostMapping("/buildings/{id}/daily-reports")
    public void createBuildingReport(@PathVariable int id){
       buildingDailyReportDtoService.createEmptyBuildingReport(id);
    }


}
