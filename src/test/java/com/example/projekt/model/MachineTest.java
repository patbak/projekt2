package com.example.projekt.model;

import com.example.projekt.repository.MachineJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MachineTest {

    @Autowired
    private MachineJpaRepository machineJpaRepository;

    @Test
    @Transactional
    public void getMachineTest()throws Exception{

        List<Machine> machineList = machineJpaRepository.findAll();

        for (Machine machine : machineList){
            System.out.println(machine.getMachineName()+" "+machine.getInventoryNumber()+" "+machine.getComments());
           List<MachineReportHasMachines> machineReportHasMachines = machine.getMachineReportHasMachines();

           for(MachineReportHasMachines machines : machineReportHasMachines){
               Employee employee = machines.getEmployee();
               System.out.println(machines.getHasMachineId()+" "+employee.getEmployeeName()+" "+employee.getEmployeeLastName());
           }
        }
        assertTrue(machineList.size()>0);
    }

}
