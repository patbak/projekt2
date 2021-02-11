package com.example.projekt.controller;

import com.example.projekt.entity.DoneWorkDto;
import com.example.projekt.entity.RoleDto;
import com.example.projekt.service.DoneWorkService;
import com.example.projekt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/Roles")
    public List<RoleDto> getRoles(){

        List<RoleDto> roleDtoList = roleService.getRoles();
        return roleDtoList;
    }
}
