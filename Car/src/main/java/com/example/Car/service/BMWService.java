package com.example.Car.service;

import com.example.Car.entity.BMW;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BMWService implements DAO<BMW> {
    private final ArrayList<BMW> cars = new ArrayList<>();

    @Override
    public BMW create(int regNumber, String color, String engineType, long mileage) {
        BMW car = fillCar(regNumber, color, engineType, mileage, new BMW());
        cars.add(car);
        return car;
    }

    @Override
    public BMW get(int regNumber) {
        for (BMW car : cars)
            if (car.getRegNumber() == regNumber) {
                return car;
            }
        return null;
    }

    @Override
    public BMW update(int regNumber, String color, String engineType, long mileage) {
        for (BMW car : cars)
            if (car.getRegNumber() == regNumber) {
                return fillCar(regNumber, color, engineType, mileage, car);
            }
        return null;
    }

    @Override
    public String delete(int regNumber) {
        for (BMW car : cars)
            if (car.getRegNumber() == regNumber) {
                cars.remove(car);
                break;
            }
        return String.format("Car with number %d was deleted", regNumber);
    }

    public BMW fillCar(int regNumber, String color, String engineType, long mileage, BMW car) {
        car.setRegNumber(regNumber);
        car.setColor(color);
        car.setEngineType(engineType);
        car.setMileage(mileage);
        return car;
    }
}
