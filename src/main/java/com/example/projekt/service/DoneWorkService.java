package com.example.projekt.service;

import com.example.projekt.dto.*;
import com.example.projekt.model.DailyWorkReport;
import com.example.projekt.model.LabourStandard;
import com.example.projekt.model.QualityAssessment;
import com.example.projekt.model.WorkDone;
import com.example.projekt.repository.DailyWorkReportJpaRepository;
import com.example.projekt.repository.LabourStandardJpaRepository;
import com.example.projekt.repository.QualityAssessmentJpaRepository;
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
    @Autowired
    private DailyWorkReportJpaRepository dailyWorkReportJpaRepository;
    @Autowired
    private LabourStandardJpaRepository labourStandardJpaRepository;
    @Autowired
    private QualityAssessmentJpaRepository qualityAssessmentJpaRepository;

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

    public DoneWorkDto setDoneWork(WorkDone workDone){
        QualityAssessment qualityAssessment = workDone.getQualityAssessment();
        LabourStandard labourStandard = workDone.getLabourStandard();
        DailyWorkReport dailyWorkReport = workDone.getDailyWorkReport();
        QualityEvaluationDto qualityEvaluationDto = qualityEvaluationDtoService.setQualityEvaluationDto(qualityAssessment);
        LabourNormDto labourNormDto = labourNormDtoService.setLabourNorm(labourStandard);
        BrigadeDailyReportDto brigadeDailyReportDto = brigadeDailyReportService.setBrigadeReport(dailyWorkReport);
        DoneWorkDto doneWorkDto = new DoneWorkDto(
                workDone.getWorkDoneId(),
                workDone.getQuantity(),
                brigadeDailyReportDto,
                labourNormDto,
                qualityEvaluationDto
        );
        return doneWorkDto;
    }

    public void createDoneWork(int brigadeReportId, DoneWorkCommandDto doneWorkCommandDto){

        DailyWorkReport dailyWorkReport = dailyWorkReportJpaRepository.getOne(brigadeReportId);
        LabourStandard labourStandard = labourStandardJpaRepository.getOne(doneWorkCommandDto.getLabourNormId());
        QualityAssessment qualityAssessment = qualityAssessmentJpaRepository.getOne(doneWorkCommandDto.getQualityEvaluationId());
        WorkDone workDone = new WorkDone();
        workDone.setQuantity(doneWorkCommandDto.getQuantityOfWork());
        workDone.setDailyWorkReport(dailyWorkReport);
        workDone.setLabourStandard(labourStandard);
        workDone.setQualityAssessment(qualityAssessment);
        workDoneJpaRepository.saveAndFlush(workDone);
    }

    public void updateDoneWork(DoneWorkCommandDto doneWorkCommandDto, int doneWorkId){
        WorkDone workDone = workDoneJpaRepository.getOne(doneWorkId);
        QualityAssessment qualityAssessment = qualityAssessmentJpaRepository.getOne(doneWorkCommandDto.getQualityEvaluationId());
        LabourStandard labourStandard = labourStandardJpaRepository.getOne(doneWorkCommandDto.getLabourNormId());
        workDone.setQuantity(doneWorkCommandDto.getQuantityOfWork());
        workDone.setQualityAssessment(qualityAssessment);
        workDone.setLabourStandard(labourStandard);
        workDoneJpaRepository.saveAndFlush(workDone);
    }




}
