package com.example.projekt.model;

import com.example.projekt.repository.DailyWorkReportJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class DailyWorkReportTest {

    @Autowired
    private DailyWorkReportJpaRepository dailyWorkReportJpaRepository;

    @Test
    @Transactional
    public void getUsedMaterialsByDailyWorkReportTest()throws Exception{

        DailyWorkReport dailyWorkReport = dailyWorkReportJpaRepository.getOne(1);

        System.out.println(dailyWorkReport.getReportNumber());
        System.out.println(dailyWorkReport.getReportDate());
        User user = dailyWorkReport.getUser();
        System.out.println(user.getName());
        System.out.println(user.getLastName());
        System.out.println(user.getLogin());
        List<UsedMaterial> usedMaterials = dailyWorkReport.getUsedMaterials();
        for(int i=0;i<usedMaterials.size();i++){
            UsedMaterial usedMaterial = usedMaterials.get(i);
            System.out.println(usedMaterial.getUsedMaterialId());
            System.out.println(usedMaterial.getQuantity());
            Material material = usedMaterial.getMaterial();
            System.out.println(material.getMaterialName());
            System.out.println(material.getMaterialUnit());
        }
    }

    @Test
    @Transactional
    public void getWorksDoneByDailyWorkReportTest()throws Exception{

        DailyWorkReport dailyWorkReport = dailyWorkReportJpaRepository.getOne(1);

        System.out.println(dailyWorkReport.getReportNumber());
        System.out.println(dailyWorkReport.getReportDate());
       WorkDone workDone = dailyWorkReport.getWorksDone().get(0);
        QualityAssessment qualityAssessment = workDone.getQualityAssessment();
        LabourStandard labourStandard = workDone.getLabourStandard();
        System.out.println(workDone.getQuantity()+"work done");
        System.out.println(qualityAssessment.getQualityAssessmentName()+" quality assesment");
        System.out.println(qualityAssessment.getValue());
        System.out.println(labourStandard.getWorkName()+" labour standard");
        System.out.println(labourStandard.getLabourStandard());


    }

}
