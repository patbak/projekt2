package com.example.projekt.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "quality_evaluation")
public class QualityAssessment {

    @Id
    @GeneratedValue
    @Column(name = "id_quality_evaluation")
    private int qualityAssessmentId;

    @Column(name = "value")
    private int value;

    @Column(name = "name")
    private String qualityAssessmentName;

    @OneToMany(
            mappedBy = "qualityAssessment",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<WorkDone> worksDone;

    public List<WorkDone> getWorksDone() {
        return worksDone;
    }

    public void setWorksDone(List<WorkDone> worksDone) {
        this.worksDone = worksDone;
    }

    public int getQualityAssessmentId() {
        return qualityAssessmentId;
    }

    public void setQualityAssessmentId(int qualityAssessmentId) {
        this.qualityAssessmentId = qualityAssessmentId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getQualityAssessmentName() {
        return qualityAssessmentName;
    }

    public void setQualityAssessmentName(String qualityAssessmentName) {
        this.qualityAssessmentName = qualityAssessmentName;
    }




}
