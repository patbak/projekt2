package com.example.projekt.controller;

import com.example.projekt.entity.DoneWorkDto;
import com.example.projekt.entity.LabourNormDto;
import com.example.projekt.service.DoneWorkService;
import com.example.projekt.service.LabourNormDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class LabourNormController {

    @Autowired
    private LabourNormDtoService labourNormDtoService;

    @GetMapping("/LabourNorm")
    public List<LabourNormDto> getLabourNorms(){

        List<LabourNormDto> labourNormDtoList = labourNormDtoService.getLabourNorms();
        return labourNormDtoList;
    }

}
