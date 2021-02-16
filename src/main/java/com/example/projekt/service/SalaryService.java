package com.example.projekt.service;

import com.example.projekt.model.Employee;
import com.example.projekt.model.Hours;
import com.example.projekt.model.Salary;
import com.example.projekt.model.Timesheet;
import com.example.projekt.repository.EmployeeJpaRepository;
import com.example.projekt.repository.HoursJpaRepository;
import com.example.projekt.repository.SalaryJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;
    LocalDate startOfMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1);
    LocalDate endOfMonth = LocalDate.now().minusMonths(1).withDayOfMonth(LocalDate.now().minusMonths(1).lengthOfMonth());


/*    public void countSalary(){

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
    }*/

    @Scheduled(cron = "30 10 5 * * *")
    public void countSalary(){
        List<Employee> employeeList = employeeJpaRepository.findAll();
        List<Salary> salaries = new ArrayList<>();
        for (Employee employee:employeeList){
        List<Hours> hoursList = hoursJpaRepository.findAllByDateBetweenAndAndEmployee_EmployeeId(startOfMonth, endOfMonth, employee.getEmployeeId());
            Salary salary = new Salary();
            salary.setDate(endOfMonth);
            salary.setEmployee(employee);
        for (Hours hours:hoursList){
            System.out.println(hours.getEmployee().getEmployeeId());
            salary.addHoursSalary(hours.getHours()*employee.getHourlyRate());
            salary.addHarmfulSalary(hours.getHarmfulHours()*(employee.getHourlyRate()+HARMFUL_ALLOWANCE));
            salary.addOvertimeSalary(hours.getOvertime()*employee.getHourlyRate()*OVERTIME_ALLOWANCE);
            salary.addNightSalary(hours.getNightHours()*employee.getHourlyRate()*NIGHT_ALLOWANCE);
            salary.countAmountSalary();
            salaries.add(salary);
        }
        }
        salaryJpaRepository.saveAll(salaries);
    }





}
