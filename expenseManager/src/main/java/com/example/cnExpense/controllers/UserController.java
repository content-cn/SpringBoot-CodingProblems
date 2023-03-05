package com.example.cnExpense.controllers;

import com.example.cnExpense.entities.User;
import com.example.cnExpense.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/check-User-exist")
    public boolean checkUserExist(@RequestBody User user) {
        return userService.checkUserExist(user);
    }

    @PostMapping("/find")
    public User findUser(@RequestBody User newUser){
        return userService.findUser(newUser);
    }

    @PostMapping("save")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
