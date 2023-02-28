package com.example.cnExpense.service;

import com.example.cnExpense.DAL.APIDal;
import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class APIService{
    @Autowired
    private APIDal apiDal;

    @Transactional
    public User getUserById(Integer id){
        return apiDal.getUserById(id);
    }

    @Transactional
    public List<User> getAllUsers() {
        return apiDal.getAllUsers();
    }

    @Transactional
    public boolean checkUserExist(User user) {
        return apiDal.checkUserExist(user);
    }

    @Transactional
    public User findUser(User newUser){
        return apiDal.findUser(newUser);
    }

    @Transactional
    public User saveUser(User user) {
        return apiDal.saveUser(user);
    }

    @Transactional
    public Income getIncomeById(Integer incomeid) {
        return apiDal.getIncomeById(incomeid);
    }

    @Transactional
    public Income saveIncome(User user,Income income) {
        return apiDal.saveIncome(user,income);
    }

    @Transactional
    public Income saveExpense(Income income,Expense expense) {
        return apiDal.saveExpense(income,expense);
    }
}