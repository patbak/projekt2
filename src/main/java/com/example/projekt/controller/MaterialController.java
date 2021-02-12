package com.example.projekt.controller;

import com.example.projekt.entity.DoneWorkDto;
import com.example.projekt.entity.MaterialDto;
import com.example.projekt.service.DoneWorkService;
import com.example.projekt.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("/materials")
    public List<MaterialDto> getMaterials(){

        List<MaterialDto> materialDtoList = materialService.getMaterials();
        return materialDtoList;
    }

}
