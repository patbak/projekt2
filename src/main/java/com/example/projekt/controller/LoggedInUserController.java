package com.example.projekt.controller;

import com.example.projekt.dto.LoggedInUserDto;
import com.example.projekt.service.LoggedInUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoggedInUserController {

    @Autowired
    private LoggedInUserService loggedInUserService;

    @GetMapping("/loggedInUser")
    public LoggedInUserDto getLoggedInUser(){

      return loggedInUserService.getUserDetails();

    }

}
