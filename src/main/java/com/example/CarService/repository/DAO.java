package com.example.CarService.repository;

import java.util.Optional;

public interface DAO<T> {
    public Optional<T> get(Integer id);
    int save(T t);
}
