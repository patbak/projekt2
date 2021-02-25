package com.example.projekt.controller;

import com.example.projekt.dto.MachineDto;
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
