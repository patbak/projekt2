package com.example.projekt.controller;

import com.example.projekt.dto.Engineer;
import com.example.projekt.service.EngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private EngineerService engineerService;

    @GetMapping("/users")
    public List<Engineer> getUsers(){

        List<Engineer> engineerList = engineerService.getEngineers();
        return engineerList;
    }

}
