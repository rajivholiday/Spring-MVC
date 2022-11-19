package com.example.Car.service;

import com.example.Car.entity.Mercedes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MercedesService implements DAO<Mercedes> {
    private final ArrayList<Mercedes> cars = new ArrayList<>();

    @Override
    public Mercedes create(int regNumber, String color, String engineType, long mileage) {
        Mercedes car = fillCar(regNumber, color, engineType, mileage, new Mercedes());
        cars.add(car);
        return car;

    }

    @Override
    public Mercedes get(int regNumber) {
        for (Mercedes car : cars)
            if (car.getRegNumber() == regNumber) {
                return car;
            }
        return null;
    }

    @Override
    public Mercedes update(int regNumber, String color, String engineType, long mileage) {
        for (Mercedes car : cars)
            if (car.getRegNumber() == regNumber) {
                car.setColor(color);
                car.setEngineType(engineType);
                car.setMileage(mileage);
                return car;
            }
        return null;
    }

    @Override
    public String delete(int regNumber) {
        for (Mercedes car : cars)
            if (car.getRegNumber() == regNumber) {
                cars.remove(car);
                break;
            }
        return String.format("Car with number %d was deleted", regNumber);
    }

    public Mercedes fillCar(int regNumber, String color, String engineType, long mileage, Mercedes car) {
        car.setRegNumber(regNumber);
        car.setColor(color);
        car.setEngineType(engineType);
        car.setMileage(mileage);
        return car;
    }
}
