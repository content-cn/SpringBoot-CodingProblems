package com.codingNinjas.Bank.Account.Registration;


public class currentAccount implements Account{

    private double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void init() {
        System.out.println("Current Account has been created I'm the init() method");
    }

    @Override
    public String getAccountType() {
        return "Current Account";
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
