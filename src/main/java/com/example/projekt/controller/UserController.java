package com.example.projekt.controller;

import com.example.projekt.entity.Engineer;
import com.example.projekt.entity.MaterialDto;
import com.example.projekt.service.EngineerService;
import com.example.projekt.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private EngineerService engineerService;

    @GetMapping("/getUsers")
    public List<Engineer> getUsers(){

        List<Engineer> engineerList = engineerService.getEngineers();
        return engineerList;
    }

}
