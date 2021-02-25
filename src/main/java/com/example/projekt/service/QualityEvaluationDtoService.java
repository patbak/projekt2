package com.example.projekt.service;

import com.example.projekt.dto.QualityEvaluationDto;
import com.example.projekt.model.QualityAssessment;
import com.example.projekt.repository.QualityAssessmentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QualityEvaluationDtoService {

    @Autowired
    private QualityAssessmentJpaRepository qualityAssessmentJpaRepository;

    public List<QualityEvaluationDto> getQualityEvaluation(){
        List<QualityAssessment> qualityAssessmentList = qualityAssessmentJpaRepository.findAll();
        List<QualityEvaluationDto> qualityEvaluationDtoList = new ArrayList<>();
        for(QualityAssessment qualityAssessment:qualityAssessmentList){
        QualityEvaluationDto qualityEvaluationDto = setQualityEvaluationDto(qualityAssessment);
        qualityEvaluationDtoList.add(qualityEvaluationDto);
        }
        return qualityEvaluationDtoList;
    }


    public QualityEvaluationDto setQualityEvaluationDto(QualityAssessment qualityAssessment){
        QualityEvaluationDto qualityEvaluationDto = new QualityEvaluationDto(
                qualityAssessment.getQualityAssessmentId(),
                qualityAssessment.getValue(),
                qualityAssessment.getQualityAssessmentName()
        );
        return  qualityEvaluationDto;
    }
}
