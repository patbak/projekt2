package com.example.projekt.model;

import com.example.projekt.repository.HoursJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class HourTest {

    @Autowired
    private HoursJpaRepository hoursJpaRepository;

    @Test
    @Transactional
    public void getHoursTest()throws Exception{
        List<Hours> hoursList = hoursJpaRepository.findAll();

        for (int i=0;i<hoursList.size();i++){
            Hours hours = hoursList.get(i);
            System.out.println(hours.getHours());
            System.out.println(hours.getOvertime());
            System.out.println(hours.getNightHours());
            System.out.println(hours.getDate());
        }
    }

}
