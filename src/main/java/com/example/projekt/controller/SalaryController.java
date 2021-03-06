package com.example.projekt.controller;

import com.example.projekt.dto.HoursDto;
import com.example.projekt.dto.SalaryDto;
import com.example.projekt.service.SalaryService;
import com.example.projekt.service.WorktimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

 /*   @GetMapping("/count-salary")
   @PreAuthorize("hasAuthority('SUPERVISOR')")
    public void countSalary(){
        salaryService.countSalary();
    }*/

    @GetMapping("/salary")
    public List<SalaryDto> getSalaryByDate(@RequestParam String date){
        LocalDate localDate = LocalDate.parse(date);
        return salaryService.getSalaryByDate(localDate);
    }

    @GetMapping("/salary/{id}")
    public List<SalaryDto> getSalaryByEmployeeId(@PathVariable int id){
        return salaryService.getSalaryByEmployeeId(id);
    }
}
