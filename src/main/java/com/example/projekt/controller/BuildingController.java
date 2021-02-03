package com.example.projekt.controller;

import com.example.projekt.entity.BuildingDto;
import com.example.projekt.service.BuildingService;
import com.example.projekt.service.WorktimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/getBuildings")
    public List<BuildingDto> getBuildings(){

    List<BuildingDto> buildingDtoList = buildingService.getBuildings();
    return buildingDtoList;
    }
}
