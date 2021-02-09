package com.example.projekt.controller;

import com.example.projekt.entity.BuildingDto;
import com.example.projekt.entity.MachineDto;
import com.example.projekt.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MachineController {

    @Autowired
    private MachineService machineService;

    @GetMapping("/getMachines")
    public List<MachineDto> getMachines(){

        List<MachineDto> machineDtoList = machineService.getMachines();
        return machineDtoList;
    }
}
