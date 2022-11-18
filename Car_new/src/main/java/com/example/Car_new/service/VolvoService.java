package com.example.Car_new.service;

import com.example.Car_new.entity.Volvo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VolvoService implements CarDao<Volvo> {
    private final List<Volvo> cars = new ArrayList<>();

    @Override
    public List<Volvo> getAll() {
        return cars;
    }

    @Override
    public Volvo getById(int regNumber) {
        for (Volvo car : cars)
            if (car.getRegNumber() == regNumber) {
                return car;
            }
        return null;
    }

    @Override
    public void create(int regNumber, String color, String engineType, long mileage) {
        Volvo car = new Volvo();
        car.setRegNumber(regNumber);
        car.setColor(color);
        car.setEngineType(engineType);
        car.setMileage(mileage);
        cars.add(car);

    }

    @Override
    public void createCar(Volvo volvo) {
        cars.add(volvo);

    }

    @Override
    public void updateCar(int regNumber, Volvo volvo) {
        for (Volvo car : cars)
            if (car.getRegNumber() == regNumber) {
                car.setColor(volvo.getColor());
                car.setEngineType(volvo.getEngineType());
                car.setMileage(volvo.getMileage());
            }

    }

    @Override
    public void update(int regNumber, String color, String engineType, long mileage) {


    }

    @Override
    public void delete(int regNumber) {

    }
}
