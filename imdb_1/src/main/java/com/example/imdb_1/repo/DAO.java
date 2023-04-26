package com.example.imdb_1.repo;

import java.util.Optional;

public interface DAO<T> {
    public Optional<T> get(Integer  id);
    int save(T t);
}
