package com.example.imdb_1.service;

import com.example.imdb_1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService  implements RegistrationService{
    @Autowired
    User imdbUser;
    @Override
    public int registerUser(String userName, String email, String password) {
        imdbUser.createUser(userName,email,password);
        return imdbUser.saveUserDetails();
    }

    @Override
    public User getNewImdbUser() {
        return imdbUser;
    }
}
