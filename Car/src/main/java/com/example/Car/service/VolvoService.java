package com.example.Car.service;

import com.example.Car.entity.Volvo;
import org.springframework.stereotype.Service;

import java.awt.image.ConvolveOp;
import java.util.ArrayList;


@Service
public class VolvoService implements DAO<Volvo> {
    private final ArrayList<Volvo> cars = new ArrayList<>();

    @Override
    public Volvo create(int regNumber, String color, String engineType, long mileage) {
        Volvo car = fillCar(regNumber, color, engineType, mileage, new Volvo());
        cars.add(car);
        return car;
    }

    @Override
    public Volvo get(int regNumber) {
        for (Volvo car : cars)
            if (car.getRegNumber() == regNumber) {
                return car;
            }
        return null;
    }

    @Override
    public Volvo update(int regNumber, String color, String engineType, long mileage) {
        for (Volvo car : cars)
            if (car.getRegNumber() == regNumber) {
                car.setColor(color);
                car.setColor(engineType);
                car.setMileage(mileage);
                return car;
            }
        return null;
    }

    @Override
    public String delete(int regNumber) {
        for (Volvo car : cars)
            if (car.getRegNumber() == regNumber) {
                cars.remove(car);
                break;
            }
        return String.format("Car with number %d was deleted ", regNumber);
    }

    public Volvo fillCar(int regNumber, String color, String engineType, long mileage, Volvo car) {
        car.setRegNumber(regNumber);
        car.setColor(color);
        car.setEngineType(engineType);
        car.setMileage(mileage);
        return car;
    }
}
