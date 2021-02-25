package com.example.projekt.service;

import com.example.projekt.dto.Account;

public interface AccountService {

    public Account create (Account account);

    void createVerificationToken(Account account, String token);

    void confirmAccount(String token);
}
