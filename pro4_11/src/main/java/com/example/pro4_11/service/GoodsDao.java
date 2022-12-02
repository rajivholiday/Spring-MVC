package com.example.pro4_11.service;

import java.util.List;
import java.util.Optional;


public interface GoodsDao<T> {
    public void create(T t);

    public Optional<T> get(int id);

    public List<T> getAll();

    public void update(int id, T t);

    public void delete(int id);

}
