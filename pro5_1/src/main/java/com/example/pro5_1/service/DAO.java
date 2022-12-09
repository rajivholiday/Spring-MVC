package com.example.pro5_1.service;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    public void create(T t);

    public List<T> getAll();

    public Optional<T> getById(int id);

    public void update(int id, T t);

    public void delete(int id);
}
