package com.example.projekt.controller;

import com.example.projekt.entity.LoggedInUserDto;
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
public class HoursController {

    @Autowired
    private WorktimeService worktimeService;

    @GetMapping("/countHours")
    @PreAuthorize("hasAuthority('SUPERVISOR')")
    public ResponseEntity<String> countWorktime(){


        worktimeService.countWorkTime();
        return new ResponseEntity<>("Czas pracy został policzony.", HttpStatus.OK);
    }

}
