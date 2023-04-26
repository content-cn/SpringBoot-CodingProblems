package com.example.imdb_1.domain;

public interface User {
    public int saveUserDetails();
    public void setUserId(Integer userId);
    public void createUser(String userName,String email,String password);
}
