package com.example.projekt.entity;

import com.example.projekt.model.LabourStandard;
import com.example.projekt.model.QualityAssessment;

public class DoneWorkDto {

    private int id;

    private float quantityOfWork;

    private BrigadeDailyReportDto brigadeDailyReportDto;

    private LabourNormDto labourNormDto;

    private QualityEvaluationDto qualityEvaluationDto;

    public DoneWorkDto(int id, float quantityOfWork, BrigadeDailyReportDto brigadeDailyReportDto, LabourNormDto labourNormDto, QualityEvaluationDto qualityEvaluationDto) {
        this.id = id;
        this.quantityOfWork = quantityOfWork;
        this.brigadeDailyReportDto = brigadeDailyReportDto;
        this.labourNormDto = labourNormDto;
        this.qualityEvaluationDto = qualityEvaluationDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getQuantityOfWork() {
        return quantityOfWork;
    }

    public void setQuantityOfWork(float quantityOfWork) {
        this.quantityOfWork = quantityOfWork;
    }

    public BrigadeDailyReportDto getBrigadeDailyReportDto() {
        return brigadeDailyReportDto;
    }

    public void setBrigadeDailyReportDto(BrigadeDailyReportDto brigadeDailyReportDto) {
        this.brigadeDailyReportDto = brigadeDailyReportDto;
    }

    public LabourNormDto getLabourNormDto() {
        return labourNormDto;
    }

    public void setLabourNormDto(LabourNormDto labourNormDto) {
        this.labourNormDto = labourNormDto;
    }

    public QualityEvaluationDto getQualityEvaluationDto() {
        return qualityEvaluationDto;
    }

    public void setQualityEvaluationDto(QualityEvaluationDto qualityEvaluationDto) {
        this.qualityEvaluationDto = qualityEvaluationDto;
    }
}
