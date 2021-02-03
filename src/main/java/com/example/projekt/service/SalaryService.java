package com.example.projekt.service;

import com.example.projekt.model.Employee;
import com.example.projekt.model.Hours;
import com.example.projekt.model.Salary;
import com.example.projekt.model.Timesheet;
import com.example.projekt.repository.EmployeeJpaRepository;
import com.example.projekt.repository.HoursJpaRepository;
import com.example.projekt.repository.SalaryJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryService {
    final double  HARMFUL_ALLOWANCE=4.0;
    final double NIGHT_ALLOWANCE=1.2;
    final double OVERTIME_ALLOWANCE=1.5;

    @Autowired
    private HoursJpaRepository hoursJpaRepository;
    @Autowired
    private SalaryJpaRepository salaryJpaRepository;

    LocalDate date = LocalDate.now().minusMonths(1).withDayOfMonth(LocalDate.now().minusMonths(1).lengthOfMonth());
    List<Salary> salaries = new ArrayList<>();

    public void countSalary(){

    List<Hours> hoursList = hoursJpaRepository.findAllByDate(date);
        for(int i=0;i<hoursList.size();i++){

        Hours hours = hoursList.get(i);
        Salary salary = new Salary();
        Employee employee = hours.getEmployee();
        salary.setHoursSalary(hours.getHours()*employee.getHourlyRate());
        salary.setDate(date);
        salary.setHarmfulHoursSalary(hours.getHarmfulHours()*HARMFUL_ALLOWANCE);
        salary.setNightHoursSalary(hours.getNightHours()*NIGHT_ALLOWANCE*employee.getHourlyRate());
        salary.setOvertimeSalary(hours.getOvertime()*employee.getHourlyRate()*OVERTIME_ALLOWANCE);
        salary.setEmployee(employee);
        salary.countAmountSalary();
        if(employee.getForemanAddition()!=0){
            salary.setAmountSalary(salary.getAmountSalary()*employee.getForemanAddition());
        }
        salaries.add(salary);
        }

    salaryJpaRepository.saveAll(salaries);
    }






}
