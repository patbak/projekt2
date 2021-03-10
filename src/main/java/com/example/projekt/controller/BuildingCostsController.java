package com.example.projekt.controller;

import com.example.projekt.dto.CostsDto;
import com.example.projekt.service.BuildingCostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BuildingCostsController {

    @Autowired
    private BuildingCostsService buildingCostsService;
/*
    @GetMapping("/buildings-costs")
    public ResponseEntity<String> countBuildingCosts(){

        buildingCostsService.countBuildingCosts();
        return new ResponseEntity<>("Koszty materiałow zostały obliczone", HttpStatus.OK);
    }*/

    @GetMapping("/building-costs/{id}")
    public List<CostsDto> getCostsByDate(@PathVariable int id){

        return buildingCostsService.getCostsByDate(id);
    }
}
