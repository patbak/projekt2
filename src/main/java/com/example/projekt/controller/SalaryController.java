package com.example.projekt.controller;

import com.example.projekt.service.SalaryService;
import com.example.projekt.service.WorktimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @GetMapping("/count-salary")
   @PreAuthorize("hasAuthority('SUPERVISOR')")
    public void countSalary(){
        salaryService.countSalary();
    }


}
