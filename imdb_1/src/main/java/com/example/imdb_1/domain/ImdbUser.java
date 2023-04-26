package com.example.imdb_1.domain;

import com.example.imdb_1.repo.DAO;
import com.example.imdb_1.repo.ImdbUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImdbUser implements User{
    @Autowired
    DAO<ImdbUser> imdbUserDAO;
    String userName;
    String email;
    String password;

    Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int saveUserDetails() {
        int imdbUserId= imdbUserDAO.save(this);
        System.out.println("new user added"+ this.userName+this.email+this.password+imdbUserId);
        return imdbUserId;
    }

    @Override
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public void createUser(String userName, String email, String password) {
        this.setEmail(email);
        this.setUserName(userName);
        this.setPassword(password);
    }
}
