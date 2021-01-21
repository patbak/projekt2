package com.example.projekt.controller;

import com.example.projekt.entity.LoggedInUserDto;
import com.example.projekt.service.LoggedInUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Access;

@RestController
public class LoggedInUserController {

    @Autowired
    private LoggedInUserService loggedInUserService;

    @GetMapping("/getLoggedInUser")
    public LoggedInUserDto getLoggedInUser(){

      return loggedInUserService.getUserDetails();

    }

}
