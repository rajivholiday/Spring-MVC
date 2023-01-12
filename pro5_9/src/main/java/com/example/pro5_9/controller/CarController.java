package com.example.pro5_9.controller;

import com.example.pro5_9.entity.Car;
import com.example.pro5_9.exceptions.NotFoundException;
import com.example.pro5_9.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/c")
public class CarController {
    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow(NotFoundException::new));
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody Car car) {
        int i = service.create(car);
        return ResponseEntity.ok(i);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Car car) {
        service.update(car);
        return new ResponseEntity<>("Car was updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Car was deleted", HttpStatus.OK);
    }
}

