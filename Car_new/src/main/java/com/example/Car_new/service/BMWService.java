package com.example.Car_new.service;

import com.example.Car_new.entity.BMW;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BMWService implements CarDao<BMW> {
    private final ArrayList<BMW> cars = new ArrayList<>();

    @Override
    public List<BMW> getAll() {
        return cars;
    }

    @Override
    public BMW getById(int regNumber) {
        for (BMW car : cars)
            if (car.getRegNumber() == regNumber) {
                return car;
            }
        return null;
    }

    @Override
    public void create(int regNumber, String color, String engineType, long mileage) {
        BMW car = new BMW();
        car.setRegNumber(regNumber);
        car.setColor(color);
        car.setEngineType(engineType);
        car.setMileage(mileage);
        cars.add(car);

    }

    @Override
    public void createCar(BMW bmw) {
        cars.add(bmw);
    }

    @Override
    public void updateCar(int regNumber, BMW bmw) {
        for (BMW car : cars)
            if (car.getRegNumber() == regNumber) {
                car.setColor(bmw.getColor());
                car.setEngineType(bmw.getEngineType());
                car.setMileage(bmw.getMileage());
            }
    }


    @Override
    public void update(int regNumber, String color, String engineType, long mileage) {
        for (BMW car : cars)
            if (car.getRegNumber() == regNumber) {
                car.setColor(color);
                car.setEngineType(engineType);
                car.setMileage(mileage);
            }

    }

    @Override
    public void delete(int regNumber) {
        for (BMW car : cars)
            if (car.getRegNumber() == regNumber) {
                cars.remove(car);
                break;
            }

    }
}
