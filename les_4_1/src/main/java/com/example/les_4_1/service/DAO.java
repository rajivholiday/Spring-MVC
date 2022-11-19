package com.example.les_4_1.service;

public interface DAO<T> {

    public String delete(int id);

    public T get(int id);

    public T create(int id, String color, String name, int age);

    public T update(int id, String color, String name, int age);


}
