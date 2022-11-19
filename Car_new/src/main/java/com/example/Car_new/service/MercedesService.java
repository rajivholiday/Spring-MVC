package com.example.Car_new.service;

import com.example.Car_new.entity.Mercedes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MercedesService implements CarDao<Mercedes> {
    private final List<Mercedes> cars = new ArrayList<>();

    @Override
    public List<Mercedes> getAll() {
        return cars;
    }

    @Override
    public Mercedes getById(int regNumber) {
        for (Mercedes car : cars)
            if (car.getRegNumber() == regNumber) {
                return car;
            }
        return null;
    }

    @Override
    public void create(int regNumber, String color, String engineType, long mileage) {
        Mercedes car = new Mercedes();
        car.setRegNumber(regNumber);
        car.setColor(color);
        car.setEngineType(engineType);
        car.setMileage(mileage);
        cars.add(car);

    }

    @Override
    public void createCar(Mercedes mercedes) {
        cars.add(mercedes);

    }

    @Override
    public void updateCar(int regNumber, Mercedes mercedes) {
        for (Mercedes car : cars)
            if (car.getRegNumber() == regNumber) {
                car.setColor(mercedes.getColor());
                car.setEngineType(mercedes.getEngineType());
                car.setMileage(mercedes.getMileage());
            }

    }

    @Override
    public void update(int regNumber, String color, String engineType, long mileage) {
        for (Mercedes car : cars)
            if (car.getRegNumber() == regNumber) {
                car.setColor(color);
                car.setEngineType(engineType);
                car.setMileage(mileage);
            }

    }

    @Override
    public void delete(int regNumber) {
        for (Mercedes car : cars)
            if (car.getRegNumber() == regNumber) {
                cars.remove(car);
                break;
            }

    }
}
