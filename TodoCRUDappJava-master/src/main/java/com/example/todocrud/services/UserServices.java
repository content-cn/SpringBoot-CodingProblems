package com.example.todocrud.services;

import com.example.todocrud.entity.Users;
import com.example.todocrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public Users getUserById (Long userId){
        return userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
    }

    public void addUser(Users user){
         userRepository.save(user);
    }

    public void deleteUser(Long userId){
        if(!userRepository.existsById(userId))
            throw new NoSuchElementException();
        userRepository.deleteById(userId);
    }

}
