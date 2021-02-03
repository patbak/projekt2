package com.example.projekt.model;


import com.example.projekt.repository.DailyMachineWorkReportJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class DailyMachineWorkReportTest {

    @Autowired
    private DailyMachineWorkReportJpaRepository dailyMachineWorkReportJpaRepository;

    @Test
    @Transactional
    public void getMachineReports()throws Exception{
        List<DailyMachineWorkReport> dailyMachineWorkReports = dailyMachineWorkReportJpaRepository.findAll();

        for (int i=0;i<dailyMachineWorkReports.size();i++){
            DailyMachineWorkReport dailyMachineWorkReport = dailyMachineWorkReports.get(i);
            System.out.println(dailyMachineWorkReport.getReportNumber()+" "+dailyMachineWorkReport.getReportDate()+" "
                    +dailyMachineWorkReport.getTask());
            List<OperatorWorkCards> operatorWorkCards =  dailyMachineWorkReport.getOperatorWorkCards();
            for (int j=0;j<operatorWorkCards.size();j++){
                OperatorWorkCards operatorWorkCard = operatorWorkCards.get(i);
                System.out.println(operatorWorkCard.getWorkCardDate()+" "+operatorWorkCard.getStartTimeOfWork()
                +" "+operatorWorkCard.getEndTimeOfWork());
            }

        }

    }


    }
