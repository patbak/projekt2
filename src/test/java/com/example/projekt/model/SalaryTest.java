package com.example.projekt.model;

import com.example.projekt.repository.SalaryJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class SalaryTest {


    @Autowired
    private SalaryJpaRepository salaryJpaRepository;

    @Test
    @Transactional
    public void getSalaryTest()throws Exception{


       List<Salary> salaries =  salaryJpaRepository.findAll();

       for(Salary salary:salaries){
           Employee employee = salary.getEmployee();
           System.out.println(
                   salary.getHoursSalary()+" "+salary.getNightHoursSalary()
                   +" "+salary.getAmountSalary()+" "+salary.getDate()
                   +" "+employee.getEmployeeName()+" "+employee.getEmployeeLastName()
           );


       }

    }

    @Test
    @Transactional
    public void getSalaryByDateTest()throws Exception{

        LocalDate localDate = LocalDate.parse("2021-01-31");
        List<Salary> salaries =  salaryJpaRepository.findAllByDate(localDate);
        for(Salary salary:salaries){
            Employee employee = salary.getEmployee();
            System.out.println(
                    salary.getHoursSalary()+" "+salary.getNightHoursSalary()
                            +" "+salary.getAmountSalary()+" "+salary.getDate()
                            +" "+employee.getEmployeeName()+" "+employee.getEmployeeLastName()
            );
        }
    }
}
