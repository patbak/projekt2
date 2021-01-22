package com.example.projekt.controller;

import com.example.projekt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VerificationController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/accountConfirm")
    public void confirmAccount(@RequestParam("token") String token){

        System.out.println("potwierdzenie rejestracji");
        accountService.confirmAccount(token);
    }

/*    @PostMapping("/accountConfirm")
    public void confirmAccount(@RequestParam("token") String token){

        System.out.println("potwierdzenie rejestracji");
        accountService.confirmAccount(token);
    }*/

}
