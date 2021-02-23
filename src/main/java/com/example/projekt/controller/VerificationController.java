package com.example.projekt.controller;

import com.example.projekt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class VerificationController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/account-confirm")
    public void confirmAccount(@RequestParam("token") String token){
        accountService.confirmAccount(token);
    }


}
