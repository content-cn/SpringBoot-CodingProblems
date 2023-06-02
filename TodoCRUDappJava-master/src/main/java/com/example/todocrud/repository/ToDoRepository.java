package com.example.todocrud.repository;

import com.example.todocrud.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Todo,Long> {
}
