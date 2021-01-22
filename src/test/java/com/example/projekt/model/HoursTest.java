package com.example.projekt.model;

import com.example.projekt.repository.HoursJpaRepository;
import com.example.projekt.service.SalaryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class HoursTest {

    @Autowired
    private HoursJpaRepository hoursJpaRepository;
    @Autowired
    private SalaryService salaryService;

    @Test
    @Transactional
    public void testGetLastMonthHours(){
        List<Hours> hoursList = hoursJpaRepository.findAllByMonth("DECEMBER");

        for(int i=0;i<hoursList.size();i++){
            System.out.println(hoursList.get(i).getHours());
            System.out.println(hoursList.get(i).getHarmfulHours());
            System.out.println(hoursList.get(i).getOvertime());
            System.out.println(hoursList.get(i).getNightHours());
            System.out.println(" ");

        }

    }

    @Test
    @Transactional
    @Rollback(false)
    public void testSalaryService(){
        salaryService.countSalary();
    }

}
