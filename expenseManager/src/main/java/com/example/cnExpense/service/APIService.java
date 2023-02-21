package com.example.cnExpense.service;
import com.example.cnExpense.DAL.APIDal;
import com.example.cnExpense.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class APIService{
    @Autowired
    private APIDal apiDal;

    public List<User> getAllUsers() {
        return apiDal.getAllUsers();
    }

    public boolean checkUserExist(User user) {
        return apiDal.checkUserExist(user);
    }
    public String save(User user) {
        return apiDal.save(user);
    }
}