package com.example.projekt.controller;

import com.example.projekt.entity.MaterialUsedDto;
import com.example.projekt.service.MaterialUsedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaterialUsedController {

    @Autowired
    private MaterialUsedService materialUsedService;

    @GetMapping("/MaterialsUsed")
    public List<MaterialUsedDto> getMaterialsUsed(){

        List<MaterialUsedDto> materialUsedDtoList = materialUsedService.getMaterialsUsed();
        return materialUsedDtoList;
    }
}
