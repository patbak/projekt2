package com.example.projekt.entity;

import com.example.projekt.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;


public class Engineer {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String login;

    private String phoneNumber;
    @JsonIgnore
    private String password;

    private String permissionNumber;

    private List<SimpleGrantedAuthority> roles;

    public Engineer() {
    }

    public Engineer(int id, String firstName, String lastName, String email, String login, String phoneNumber, String password, String permissionNumber, List<SimpleGrantedAuthority> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.permissionNumber = permissionNumber;
        this.roles = roles;
    }

    public int getUserId() {
        return id;
    }

    public void setUserId(int userId) {
        this.id = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermissionNumber() {
        return permissionNumber;
    }

    public void setPermissionNumber(String permissionNumber) {
        this.permissionNumber = permissionNumber;
    }

    public List<SimpleGrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(List<SimpleGrantedAuthority> roles) {
        this.roles = roles;
    }
}
