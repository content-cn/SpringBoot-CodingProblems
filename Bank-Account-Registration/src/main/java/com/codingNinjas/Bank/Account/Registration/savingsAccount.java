package com.codingNinjas.Bank.Account.Registration;


public class savingsAccount implements Account{
    private double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String getAccountType() {
        return "Savings Account";
    }

    @Override
    public void addBalance(double balance) {
        this.balance += balance;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }
}
