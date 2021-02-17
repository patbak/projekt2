package com.example.projekt.entity;

public class DoneWorkDto {

    private int id;

    private float quantityOfWork;

    private BrigadeDailyReportDto brigadeDailyReport;

    private LabourNormDto labourNorm;

    private QualityEvaluationDto qualityEvaluation;

    public DoneWorkDto(int id, float quantityOfWork, BrigadeDailyReportDto brigadeDailyReportDto, LabourNormDto labourNormDto, QualityEvaluationDto qualityEvaluationDto) {
        this.id = id;
        this.quantityOfWork = quantityOfWork;
        this.brigadeDailyReport = brigadeDailyReportDto;
        this.labourNorm = labourNormDto;
        this.qualityEvaluation = qualityEvaluationDto;
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

    public BrigadeDailyReportDto getBrigadeDailyReport() {
        return brigadeDailyReport;
    }

    public void setBrigadeDailyReport(BrigadeDailyReportDto brigadeDailyReport) {
        this.brigadeDailyReport = brigadeDailyReport;
    }

    public LabourNormDto getLabourNorm() {
        return labourNorm;
    }

    public void setLabourNorm(LabourNormDto labourNorm) {
        this.labourNorm = labourNorm;
    }

    public QualityEvaluationDto getQualityEvaluation() {
        return qualityEvaluation;
    }

    public void setQualityEvaluation(QualityEvaluationDto qualityEvaluation) {
        this.qualityEvaluation = qualityEvaluation;
    }
}
