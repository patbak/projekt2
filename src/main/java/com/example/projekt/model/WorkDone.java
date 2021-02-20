package com.example.projekt.model;


import javax.persistence.*;

@Entity
@Table(name = "done_works")
public class WorkDone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_done_work")
    private int WorkDoneId;

    @Column(name = "quantity_of_work")
    private float Quantity;

    @ManyToOne
    @JoinColumn(name = "brigade_daily_reports_id_brigade_daily_report")
    private DailyWorkReport dailyWorkReport;

    @ManyToOne
    @JoinColumn(name = "quality_evaluation_id_quality_evaluation")
    private QualityAssessment qualityAssessment;

    @ManyToOne
    @JoinColumn(name = "labour_norms_id_labour_norm")
    private LabourStandard labourStandard;

    public int getWorkDoneId() {
        return WorkDoneId;
    }

    public void setWorkDoneId(int workDoneId) {
        WorkDoneId = workDoneId;
    }

    public float getQuantity() {
        return Quantity;
    }

    public void setQuantity(float quantity) {
        Quantity = quantity;
    }

    public DailyWorkReport getDailyWorkReport() {
        return dailyWorkReport;
    }

    public void setDailyWorkReport(DailyWorkReport dailyWorkReport) {
        this.dailyWorkReport = dailyWorkReport;
    }

    public QualityAssessment getQualityAssessment() {
        return qualityAssessment;
    }

    public void setQualityAssessment(QualityAssessment qualityAssessment) {
        this.qualityAssessment = qualityAssessment;
    }

    public LabourStandard getLabourStandard() {
        return labourStandard;
    }

    public void setLabourStandard(LabourStandard labourStandard) {
        this.labourStandard = labourStandard;
    }



}
