package com.example.projekt.event;

import com.example.projekt.dto.Account;
import org.springframework.context.ApplicationEvent;

public class UserRegistrationEvent extends ApplicationEvent {
    private static final long serialVersionUID = -4113549487933175429L;
    private final Account account;
    private String appUrl;
    public UserRegistrationEvent(Account account, String appUrl) {
        super(account);
        this.account=account;
        this.appUrl=appUrl;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Account getAccount() {
        return account;
    }

    public String getAppUrl() {
        return appUrl;
    }
}
