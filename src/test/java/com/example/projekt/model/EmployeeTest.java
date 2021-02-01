package com.example.projekt.model;

import com.example.projekt.repository.EmployeeJpaRepository;
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
    public void getEmployeesTest()throws Exception{

        List<Employee> employees = employeeJpaRepository.findAll();
        assertTrue(employees.size()>0);
        Employee employee = employees.get(0);
        System.out.println(employee.getEmployeeName()+" "+employee.getEmployeeLastName());
        System.out.println(employee.getHourlyRate());
        List<Timesheet> timesheets = employee.getTimesheets();
        Timesheet timesheet = timesheets.get(0);
        System.out.println(timesheet.getStartTimeOfWork()+" "+timesheet.getEndTimeOfWork()+" "+timesheet.getHarmfulHours()+
                timesheet.getTimesheetDate());
        List<Hours> hoursList = employee.getHours();
        Hours hours = hoursList.get(0);
        System.out.println(hours.getHours()+" "+hours.getHarmfulHours()+" "+ hours.getNightHours());
        List<Salary> salaries = employee.getSalaries();
        Salary salary = salaries.get(0);
        System.out.println(salary.getHoursSalary()+" "+salary.getHarmfulHoursSalary()+" "+salary.getNightHoursSalary());
        System.out.println("Rapot maszyn:");
        List<MachineReportHasMachines> machineReportHasMachines = employee.getMachineReportHasMachines();
        MachineReportHasMachines machineReportHasMachine = machineReportHasMachines.get(0);
        System.out.println(machineReportHasMachine.getHasMachineId());
        Machine machine = machineReportHasMachine.getMachine();
        System.out.println(machine.getMachineName()+" "+machine.getInventoryNumber());
        List<OperatorWorkCards> operatorWorkCards = employee.getOperatorWorkCards();
        OperatorWorkCards operatorWorkCard = operatorWorkCards.get(0);
        System.out.println(operatorWorkCard.getWorkCardDate()+" "+operatorWorkCard.getStartTimeOfWork()+" "+operatorWorkCard.getEndTimeOfWork());

    }

}
