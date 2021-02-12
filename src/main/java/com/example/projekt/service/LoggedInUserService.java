package com.example.projekt.service;

import com.example.projekt.entity.LoggedInUserDto;
import com.example.projekt.model.Role;
import com.example.projekt.model.User;
import com.example.projekt.repository.UserJpaRepository;
import com.example.projekt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class LoggedInUserService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    public LoggedInUserDto getUserDetails(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userJpaRepository.findByLogin(currentPrincipalName);
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }


        LoggedInUserDto loggedInUserDto = new LoggedInUserDto(
                user.getUserId(),
                user.getPermissionNumber(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getLogin(),
                user.getPhoneNumber(),
                authorities
        );

        return loggedInUserDto;

    }

}
