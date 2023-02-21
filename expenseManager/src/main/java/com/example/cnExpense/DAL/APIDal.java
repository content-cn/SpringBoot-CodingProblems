package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.User;

import java.util.List;

public interface APIDal {
    List<User> getAllUsers();

    boolean checkUserExist(User user);

    public String save(User user);
}