package com.codingNinjas.Bank.Account.Registration;

import java.util.ArrayList;
import java.util.List;

public class myUser implements User{

    private String name;
    private List<Account> accountList = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
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
