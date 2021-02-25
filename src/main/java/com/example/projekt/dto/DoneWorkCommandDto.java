package com.example.projekt.dto;

public class DoneWorkCommandDto {

    private float quantityOfWork;

    private int brigadeDailyReport;

    private int labourNormId;

    private int qualityEvaluationId;


    public DoneWorkCommandDto(float quantityOfWork, int brigadeDailyReport, int labourNormId, int qualityEvaluationId) {
        this.quantityOfWork = quantityOfWork;
        this.brigadeDailyReport = brigadeDailyReport;
        this.labourNormId = labourNormId;
        this.qualityEvaluationId = qualityEvaluationId;
    }

    public float getQuantityOfWork() {
        return quantityOfWork;
    }

    public void setQuantityOfWork(float quantityOfWork) {
        this.quantityOfWork = quantityOfWork;
    }

    public int getBrigadeDailyReport() {
        return brigadeDailyReport;
    }

    public void setBrigadeDailyReport(int brigadeDailyReport) {
        this.brigadeDailyReport = brigadeDailyReport;
    }

    public int getLabourNormId() {
        return labourNormId;
    }

    public void setLabourNormId(int labourNormId) {
        this.labourNormId = labourNormId;
    }

    public int getQualityEvaluationId() {
        return qualityEvaluationId;
    }

    public void setQualityEvaluationId(int qualityEvaluationId) {
        this.qualityEvaluationId = qualityEvaluationId;
    }
}
