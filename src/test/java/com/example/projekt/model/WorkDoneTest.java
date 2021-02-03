package com.example.projekt.model;

import com.example.projekt.repository.SalaryJpaRepository;
import com.example.projekt.repository.WorkDoneJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class WorkDoneTest {

    @Autowired
    private WorkDoneJpaRepository repository;

    @Test
    @Transactional
    public void getWorkDoneTest()throws Exception{
        List<WorkDone> workDoneList = repository.findAll();

        for(WorkDone workDone: workDoneList){
            DailyWorkReport dailyWorkReport = workDone.getDailyWorkReport();
            LabourStandard labourStandard = workDone.getLabourStandard();
            QualityAssessment qualityAssessment = workDone.getQualityAssessment();
            System.out.println(
                    workDone.getWorkDoneId()+" "+workDone.getQuantity()+
                            " "+dailyWorkReport.getReportNumber()+" "+
                            dailyWorkReport.getReportDate()+" "+
                            labourStandard.getWorkName()+" "+labourStandard.getLabourStandard()+
                            " "+qualityAssessment.getQualityAssessmentName()+" "+qualityAssessment.getValue()
            );

        }
    }

}
