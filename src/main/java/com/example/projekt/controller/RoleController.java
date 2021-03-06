package com.example.projekt.controller;

import com.example.projekt.dto.RoleDto;
import com.example.projekt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public List<RoleDto> getRoles(){

        List<RoleDto> roleDtoList = roleService.getRoles();
        return roleDtoList;
    }
}
