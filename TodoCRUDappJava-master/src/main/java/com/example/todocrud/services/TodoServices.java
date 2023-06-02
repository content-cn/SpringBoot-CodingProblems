package com.example.todocrud.services;

import com.example.todocrud.entity.Todo;
import com.example.todocrud.entity.Users;
import com.example.todocrud.repository.ToDoRepository;
import com.example.todocrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TodoServices {

    @Autowired

     UserServices userServices;
    @Autowired
     ToDoRepository toDoRepository;
    @Autowired

     UserRepository userRepository;

    public Todo getTodoById(Long todoId){
        return toDoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
    }

    public void addTodo(Long userId, Todo todo){
        Users user = userServices.getUserById(userId);
        user.getTodoList().add(todo);
        toDoRepository.save(todo);
        userRepository.save(user);
    }


    public void toggleTodoCompleted(Long todoId){
        Todo todo = this.getTodoById(todoId);
        todo.setCompleted(!todo.getCompleted());
        toDoRepository.save(todo);
    }

    public void deleteTodo(Long userId,Long todoId){
        Users user = userServices.getUserById(userId);
        Todo todo = this.getTodoById(todoId);
        user.getTodoList().remove(todo);
        userRepository.save(user);
        toDoRepository.delete(todo);
    }


}
