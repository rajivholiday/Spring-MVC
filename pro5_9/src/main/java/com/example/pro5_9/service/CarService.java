package com.example.pro5_9.service;

import com.example.pro5_9.entity.Car;
import com.example.pro5_9.exceptions.NotFoundException;
import com.example.pro5_9.repository.CarRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepo repo;


    public CarService(CarRepo repo) {
        this.repo = repo;
    }

    public int create(Car car) {
        return repo.save(car).getId();
    }

    public List<Car> getAll() {
        return repo.findAll();
    }

    public Optional<Car> getById(int id) {
        return repo.findById(id);
    }

    public void update(Car car) {
        Car car1 = getById(car.getId()).orElseThrow(NotFoundException::new);
        car1.setModel(car.getModel());
        car1.setProduction_year(car.getProduction_year());
        repo.save(car1);

    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
