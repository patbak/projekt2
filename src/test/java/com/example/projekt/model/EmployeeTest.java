package com.example.projekt.model;


import com.example.projekt.repository.EmployeeJpaRepository;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class EmployeeTest {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @Test
    @Transactional
    public void testJpaGetEmployee(){
        Employee employee  = employeeJpaRepository.getOne(2);
        assertTrue(employee.getEmployeeName().equals("Patryk"));

        System.out.print("Imie: " + employee.getEmployeeName()+
                        " Nazwisko: " + employee.getEmployeeLastName()+
                        " Stawka godzinowa: " + employee.getHourlyRate());

    }


/*    @Test
    @Transactional
    public void testGetEployeeHours(){
        Employee employee  = employeeJpaRepository.getOne(2);
        List<Hours> hoursList = employeeJpaRepository.findAllByMonth("DECEMBER");
        for(int i=0;i<hoursList.size();i++){
            System.out.println(hoursList.get(i).getHours());
            System.out.println(hoursList.get(i).getNightHours());
            System.out.println(hoursList.get(i).getOvertime());
            System.out.println(hoursList.get(i).getHarmfulHours());
        }

    }*/
}
