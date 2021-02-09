package com.example.projekt.service;

import com.example.projekt.entity.BrigadeDailyReportDto;
import com.example.projekt.entity.DoneWorkDto;
import com.example.projekt.entity.LabourNormDto;
import com.example.projekt.entity.QualityEvaluationDto;
import com.example.projekt.model.LabourStandard;
import com.example.projekt.model.QualityAssessment;
import com.example.projekt.model.WorkDone;
import com.example.projekt.repository.WorkDoneJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoneWorkService {

    @Autowired
    private WorkDoneJpaRepository workDoneJpaRepository;
    @Autowired
    private BrigadeDailyReportService brigadeDailyReportService;
    @Autowired
    private LabourNormDtoService labourNormDtoService;
    @Autowired
    private QualityEvaluationDtoService qualityEvaluationDtoService;

    public List<DoneWorkDto> getDoneWork(){
    List<WorkDone> workDoneList = workDoneJpaRepository.findAll();
    List<DoneWorkDto> doneWorkDtoList = new ArrayList<>();
    for(WorkDone workDone:workDoneList){
        BrigadeDailyReportDto brigadeDailyReportDto = brigadeDailyReportService.setBrigadeReport(workDone.getDailyWorkReport());
        LabourNormDto labourNormDto = labourNormDtoService.setLabourNorm(workDone.getLabourStandard());
        QualityEvaluationDto qualityEvaluationDto = qualityEvaluationDtoService.setQualityEvaluationDto(workDone.getQualityAssessment());
        DoneWorkDto doneWorkDto = new DoneWorkDto(
                workDone.getWorkDoneId(),
                workDone.getQuantity(),
                brigadeDailyReportDto,
                labourNormDto,
                qualityEvaluationDto
        );
        doneWorkDtoList.add(doneWorkDto);
    }
    return doneWorkDtoList;

    }





}
