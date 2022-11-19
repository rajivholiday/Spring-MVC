package com.example.Car.service;

public interface DAO<T> {
    public T create(int regNumber, String color, String engineType, long mileage);

    public T get(int regNumber);

    public T update(int regNumber, String color, String engineType, long mileage);

    public String delete(int regNumber);
}
