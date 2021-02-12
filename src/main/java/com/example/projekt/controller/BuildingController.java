package com.example.projekt.controller;

import com.example.projekt.entity.BrigadeDailyReportDto;
import com.example.projekt.entity.BuildingDailyReportsDto;
import com.example.projekt.entity.BuildingDto;
import com.example.projekt.entity.Engineer;
import com.example.projekt.service.BuildingService;
import com.example.projekt.service.WorktimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

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
    public ResponseEntity<String> postBuilding(@RequestBody BuildingDto buildingDto){

        buildingService.saveBuilding(buildingDto);
        return new ResponseEntity<>("Budowa została dodana.", HttpStatus.OK);

    }

    @GetMapping("/buildings/{id}/Engineer")
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

    @PostMapping("/buildings/{id}/Engineer")
    public ResponseEntity<String>  addEngineersToBuilding(@PathVariable int id, @RequestBody Engineer engineer){

        buildingService.addEngineerToBuilding(id, engineer);

       return  new ResponseEntity<>("Dodano inżyniera do budowy", HttpStatus.OK);
    }

    @GetMapping("/buildings/{id}/daily-reports")
    public List<BuildingDailyReportsDto> getDailyReportsFromBuilding(@PathVariable int id){

      return  buildingService.getBuildingReports(id);
    }


}
