package com.example.projekt.model;

import com.example.projekt.repository.LabourStandardJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class LabourStandardTest {

    @Autowired
    private LabourStandardJpaRepository labourStandardJpaRepository;

    @Test
    @Transactional
    public void getReportsTest()throws Exception{
       List<LabourStandard> labourStandardList = labourStandardJpaRepository.findAll();

       for (int i=0;i<labourStandardList.size();i++){
           LabourStandard labourStandard = labourStandardList.get(i);
           List<WorkDone> workDones = labourStandard.getWorkDoneList();
           System.out.println(labourStandard.getWorkName()+" "+labourStandard.getLabourStandard());
           for (int j=0;j<workDones.size();j++){
               WorkDone workDone = workDones.get(j);
               System.out.println(workDone.getWorkDoneId()+"  "+workDone.getQuantity());

           }
       }
    }

}
