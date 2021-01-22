package com.example.projekt.service;

import com.example.projekt.entity.Account;
import com.example.projekt.model.Role;
import com.example.projekt.model.User;
import com.example.projekt.model.VerificationToken;
import com.example.projekt.repository.AccountRepository;
import com.example.projekt.repository.RoleJpaRepository;
import com.example.projekt.repository.UserJpaRepository;
import com.example.projekt.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private RoleJpaRepository roleJpaRepository;


    @Override
    public Account create(Account account) {
        return accountRepository.saveAndFlush(account);
    }

    @Override
    public void createVerificationToken(Account account, String token) {
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUsername(account.getLogin());
        verificationToken.setExpiryDate(verificationToken.calculateExpiryDate(verificationToken.EXPIRATION));
        System.out.println(verificationToken.getToken());
        System.out.println(verificationToken.getUsername());
        System.out.println(verificationToken.getExpiryDate());
        verificationTokenRepository.saveAndFlush(verificationToken);

    }

    @Override
    public void confirmAccount(String token) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        Role role = roleJpaRepository.getOne((long) 1);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        if(verificationToken.getExpiryDate().after(new Date())){
            Account account = accountRepository.findByLogin(verificationToken.getUsername());
            User user = new User();
            user.setName(account.getName());
            user.setLastName(account.getLastName());
            user.setEmail(account.getEmail());
            user.setLogin(account.getLogin());
            user.setPassword(account.getPassword());
            user.setPhoneNumber(account.getPhoneNumber());
            user.setSupervisor(account.isSupervisor());
            user.setRoles(roles);
            userJpaRepository.saveAndFlush(user);
            accountRepository.deleteById(account.getUserId());
            verificationTokenRepository.deleteById(verificationToken.getToken());

        }

    }
}
