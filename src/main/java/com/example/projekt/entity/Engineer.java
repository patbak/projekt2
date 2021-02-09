package com.example.projekt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;

public class Engineer {

    private int userId;

    private String name;

    private String lastName;

    private String email;

    private String login;

    private String phoneNumber;
    @JsonIgnore
    private String password;

    private String permissionNumber;

    public Engineer() {
    }

    public Engineer(int userId, String name, String lastName, String email, String login, String phoneNumber, String password, String permissionNumber) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.permissionNumber = permissionNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
