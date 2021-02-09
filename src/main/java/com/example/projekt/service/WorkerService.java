package com.example.projekt.service;

import com.example.projekt.entity.WorkerDto;
import com.example.projekt.model.Employee;
import com.example.projekt.repository.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    public List<WorkerDto> getWorkers(){
        List<Employee> employeeList = employeeJpaRepository.findAll();
        List<WorkerDto> workerDtoList = new ArrayList<>();
        for(Employee employee:employeeList){
            WorkerDto workerDto =setWorker(employee);
            workerDtoList.add(workerDto);
        }
        return  workerDtoList;
    }

    public WorkerDto setWorker(Employee employee){
        WorkerDto workerDto = new WorkerDto(
                employee.getEmployeeId(),
                employee.getEmployeeName(),
                employee.getEmployeeLastName(),
                employee.getHourlyRate(),
                employee.getForemanAddition(),
                employee.isStackerOperator(),
                employee.isRollerOperator(),
                employee.isExcavatorOperator(),
                employee.isBackholeOperator(),
                employee.isGraderOperator(),
                employee.isMilingMachineOperator(),
                employee.isLoaderOperator(),
                employee.isBulldozerOperator(),
                employee.isCraneOperator()
        );
        return workerDto;
    }

}
