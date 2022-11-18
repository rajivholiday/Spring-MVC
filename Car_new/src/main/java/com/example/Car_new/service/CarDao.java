package com.example.Car_new.service;

import java.util.List;

public interface CarDao<T> {
    public List<T> getAll();

    public T getById(int regNumber);

    public void create(int regNumber, String color, String engineType, long mileage);

    public void createCar(T t);

    public void updateCar(int regNumber, T t);

    public void update(int regNumber, String color, String engineType, long mileage);

    public void delete(int regNumber);


}
