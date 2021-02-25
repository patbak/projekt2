package com.example.projekt.controller;

import com.example.projekt.dto.QualityEvaluationDto;
import com.example.projekt.service.QualityEvaluationDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QualityEvaluationController {

    @Autowired
    private QualityEvaluationDtoService qualityEvaluationDtoService;

    @GetMapping("/quality-evaluation")
    public List<QualityEvaluationDto> getMaterials(){

        List<QualityEvaluationDto> qualityEvaluationDtoList = qualityEvaluationDtoService.getQualityEvaluation();
        return qualityEvaluationDtoList;
    }


}
