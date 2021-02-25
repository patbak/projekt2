package com.example.projekt.controller;

import com.example.projekt.dto.WorkerDto;
import com.example.projekt.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/workers")
    public List<WorkerDto> getBuildings(){

        List<WorkerDto> workerDtoList = workerService.getWorkers();
        return workerDtoList;
    }
}
