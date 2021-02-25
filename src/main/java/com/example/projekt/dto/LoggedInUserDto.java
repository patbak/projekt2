package com.example.projekt.dto;


import java.util.List;

public class LoggedInUserDto {
    private int id;

    private String permissionNumber;

    private String firstName;

    private String lastName;

    private String email;

    private String login;

    private String phoneNumber;

    private List<RoleDto> role;
/*

    private List<SimpleGrantedAuthority> roles;
*/

    public LoggedInUserDto(int id, String permissionNumber, String firstName, String lastName, String email, String login, String phoneNumber, List<RoleDto> role) {
        this.id = id;
        this.permissionNumber = permissionNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.phoneNumber = phoneNumber;
        this.role = role;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermissionNumber() {
        return permissionNumber;
    }

    public void setPermissionNumber(String permissionNumber) {
        this.permissionNumber = permissionNumber;
    }

    public List<RoleDto> getRole() {
        return role;
    }

    public void setRole(List<RoleDto> role) {
        this.role = role;
    }
}
