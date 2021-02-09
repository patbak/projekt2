package com.example.projekt.controller;

import com.example.projekt.entity.MaterialDto;
import com.example.projekt.entity.QualityEvaluationDto;
import com.example.projekt.service.QualityEvaluationDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QualityEvaluationController {

    @Autowired
    private QualityEvaluationDtoService qualityEvaluationDtoService;

    @GetMapping("/getQualityEvaluation")
    public List<QualityEvaluationDto> getMaterials(){

        List<QualityEvaluationDto> qualityEvaluationDtoList = qualityEvaluationDtoService.getQualityEvaluation();
        return qualityEvaluationDtoList;
    }


}
