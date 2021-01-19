package com.example.projekt.entity;


import com.example.projekt.model.Role;
import com.example.projekt.validation.PasswordPolicy;
import com.example.projekt.validation.UniqueEmail;
import com.example.projekt.validation.UniqueUsername;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class LoggedInUserDto {

    private String firstname;

    private String lastname;

    private String email;

    private String username;

    private String phoneNumber;

    private List<SimpleGrantedAuthority> authorities;



    public LoggedInUserDto(String firstname, String lastname, String email, String username, String phoneNumber, List<SimpleGrantedAuthority> authorities) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.authorities=authorities;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
