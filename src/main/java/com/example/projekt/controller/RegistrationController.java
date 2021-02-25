package com.example.projekt.controller;

import com.example.projekt.dto.Account;
import com.example.projekt.dto.UserDto;
import com.example.projekt.event.UserRegistrationEvent;
import com.example.projekt.repository.AccountRepository;

import com.example.projekt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RegistrationController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private AccountService accountService;


@PostMapping("/sign-up")
public void signUp(@Valid @RequestBody UserDto userDto){

    Account account = new Account();

    account.setName(userDto.getFirstname());
    account.setLastName(userDto.getLastname());
    account.setEmail(userDto.getEmail());
    account.setLogin(userDto.getUsername());
    account.setPassword(encoder.encode(userDto.getPassword()));
    account.setPhoneNumber(userDto.getPhoneNumber());
    account.setSupervisor(userDto.isSupervisor());
    account.setPermissionNumber(userDto.getPermissionNumber());
    accountRepository.saveAndFlush(account);
    eventPublisher.publishEvent(new UserRegistrationEvent(account,"uzytkownicy"));

}







}
