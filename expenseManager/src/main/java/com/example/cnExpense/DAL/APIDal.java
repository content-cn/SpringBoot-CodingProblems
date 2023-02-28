package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.User;

import java.util.List;

public interface APIDal {
    List<User> getAllUsers();

    boolean checkUserExist(User user);

    public User getUserById(Integer id);

    public User findUser(User newUser);

    public User saveUser(User user);

    public Income getIncomeById(Integer incomeid);

    public Income saveIncome(User user,Income income);

    public Income saveExpense(Income income, Expense expense);
}