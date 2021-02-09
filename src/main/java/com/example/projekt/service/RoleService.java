package com.example.projekt.service;

import com.example.projekt.entity.RoleDto;
import com.example.projekt.model.Role;
import com.example.projekt.repository.RoleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RoleService {

    @Autowired
    private RoleJpaRepository roleJpaRepository;

    public List<RoleDto> getRoles(){
        List<Role> roles =  roleJpaRepository.findAll();
        List<RoleDto> roleDtoList = new ArrayList<>();
        for(Role role:roles){
        RoleDto roleDto = setRole(role);
        roleDtoList.add(roleDto);
        }
    return roleDtoList;

    }

    public RoleDto setRole(Role role){
        RoleDto roleDto = new RoleDto(
                role.getId(),
                role.getName()
        );
        return  roleDto;
    }

}
