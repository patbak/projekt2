package com.example.projekt.controller;

import com.example.projekt.dto.MaterialUsedDto;
import com.example.projekt.service.MaterialUsedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MaterialUsedController {

    @Autowired
    private MaterialUsedService materialUsedService;

    @GetMapping("/materials-used")
    public List<MaterialUsedDto> getMaterialsUsed(){

        List<MaterialUsedDto> materialUsedDtoList = materialUsedService.getMaterialsUsed();
        return materialUsedDtoList;
    }
}
