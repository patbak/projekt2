package com.example.projekt.model;

import com.example.projekt.repository.QualityAssessmentJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class QualityAssessmentTest {


    @Autowired
    private QualityAssessmentJpaRepository repository;

    @Test
    @Transactional
    public void getQualityAssessmentTest()throws Exception{


       List<QualityAssessment> qualityAssessments = repository.findAll();

       for (QualityAssessment qualityAssessment:qualityAssessments){
           List<WorkDone> workDones =  qualityAssessment.getWorksDone();
          System.out.println(
           qualityAssessment.getQualityAssessmentName()+" "+qualityAssessment.getValue()
          );
          for (WorkDone workDone:workDones){
              System.out.println(
                      workDone.getQuantity()+" "+workDone.getWorkDoneId()
              );
          }
       }

    }

}
