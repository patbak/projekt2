package com.example.projekt.controller;

import com.example.projekt.dto.HoursDto;
import com.example.projekt.service.HoursService;
import com.example.projekt.service.WorktimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HoursController {

    @Autowired
    private WorktimeService worktimeService;
    @Autowired
    private HoursService hoursService;

 /*   @GetMapping("/countHours")
    @PreAuthorize("hasAuthority('SUPERVISOR')")
    public void countWorktime(){
        worktimeService.countWorkTime();
    }*/


    @GetMapping("/hours")
    public List<HoursDto> getHoursByDate(@RequestParam String date){
        LocalDate localDate = LocalDate.parse(date);
         return hoursService.getHoursByDate(localDate);
    }


}
