package com.example.projekt.model;


import com.example.projekt.repository.MachineReportHasMachinesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class MachineReportHasMachinesTest {

    @Autowired
    private MachineReportHasMachinesRepository repository;

    @Test
    @Transactional
    public void getReportHasMachinesTest()throws Exception{

        List<MachineReportHasMachines> machineReportHasMachinesList =  repository.findAll();
        for(MachineReportHasMachines machines : machineReportHasMachinesList){
           Employee employee = machines.getEmployee();
           System.out.println(employee.getEmployeeName()+" "+employee.getEmployeeLastName()+" "+employee.getHourlyRate());
           Machine machine = machines.getMachine();
           System.out.println(machine.getMachineName()+" "+machine.getInventoryNumber()+" "+machine.getYearOfProduction());
        }
    }

}
