package com.example.projekt.model;

import com.example.projekt.repository.OperatorWorkCardsJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class OperatorWorkCardsTest {

    @Autowired
    private OperatorWorkCardsJpaRepository repository;

    @Test
    @Transactional
    public void getMachineTest()throws Exception{

        List<OperatorWorkCards> operatorWorkCards = repository.findAll();

        for (OperatorWorkCards operatorWorkCard : operatorWorkCards){
            Employee employee = operatorWorkCard.getEmployee();
            System.out.println(
                            operatorWorkCard.getWorkCardDate()+" "+
                            operatorWorkCard.getStartTimeOfWork()+" "+
                            operatorWorkCard.getEndTimeOfWork()+" "+
                            operatorWorkCard.getHarmfulHours()+" "+
                                    employee.getEmployeeName()+" "+
                                    employee.getEmployeeLastName()

                    );
        }

    }

}
