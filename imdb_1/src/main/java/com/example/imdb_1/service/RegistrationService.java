package com.example.imdb_1.service;

import com.example.imdb_1.domain.User;

public interface RegistrationService {
    public int registerUser(String userName,String email,String password);
    public User getNewImdbUser();
}
