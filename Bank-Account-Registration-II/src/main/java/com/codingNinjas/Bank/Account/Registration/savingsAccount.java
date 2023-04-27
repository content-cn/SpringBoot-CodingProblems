package com.codingNinjas.Bank.Account.Registration;


public class savingsAccount implements Account{
    private double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void init() {
        System.out.println("Savings Account has been created I'm the init() method");
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
