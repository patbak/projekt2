package com.example.projekt.controller;

import com.example.projekt.entity.BuildingDto;
import com.example.projekt.entity.UsedEquipmentDto;
import com.example.projekt.service.BuildingService;
import com.example.projekt.service.UsedEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsedEquipmentController {

    @Autowired
    private UsedEquipmentService usedEquipmentService;

    @GetMapping("/getUsedEquipment")
    public List<UsedEquipmentDto> getUsedEquipment(){

        List<UsedEquipmentDto> usedEquipmentDtoList = usedEquipmentService.getUsedEquipment();
        return usedEquipmentDtoList;
    }

}
