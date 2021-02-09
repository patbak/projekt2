package com.example.projekt.controller;

import com.example.projekt.entity.BuildingDto;
import com.example.projekt.entity.WorkerDto;
import com.example.projekt.service.BuildingService;
import com.example.projekt.service.WorkerService;
import com.example.projekt.service.WorktimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/getWorkers")
    public List<WorkerDto> getBuildings(){

        List<WorkerDto> workerDtoList = workerService.getWorkers();
        return workerDtoList;
    }
}
