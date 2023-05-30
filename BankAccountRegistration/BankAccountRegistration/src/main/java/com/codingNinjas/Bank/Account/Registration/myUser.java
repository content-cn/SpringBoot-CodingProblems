package com.codingNinjas.Bank.Account.Registration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class myUser implements User{

    private String name;
    private List<Account> accountList = new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println("User bean has been instantiated and I'm the init() method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("User bean has been closed and I'm the destroy() method");
    }

    @Override
    public void setUserDetails(String name) {
        this.name = name;
    }

    @Override
    public void addAccount(Account account) {
        this.accountList.add(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return this.accountList;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
