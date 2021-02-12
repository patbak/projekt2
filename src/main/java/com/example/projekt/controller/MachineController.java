package com.example.projekt.controller;

import com.example.projekt.entity.BuildingDto;
import com.example.projekt.entity.MachineDto;
import com.example.projekt.model.Machine;
import com.example.projekt.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MachineController {

    @Autowired
    private MachineService machineService;

    @GetMapping("/machines")
    public List<MachineDto> getMachines(){

        List<MachineDto> machineDtoList = machineService.getMachines();
        return machineDtoList;
    }
    

}
