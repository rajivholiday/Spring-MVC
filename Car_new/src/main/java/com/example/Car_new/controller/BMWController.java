package com.example.Car_new.controller;

import com.example.Car_new.entity.BMW;
import com.example.Car_new.service.BMWService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bmw")
public class BMWController {
    private final BMWService service;

    public BMWController(BMWService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<BMW> getAll() {
        return service.getAll();
    }

    @GetMapping("/{regNumber}")
    public BMW getById(@PathVariable int regNumber) {
        return service.getById(regNumber);
    }

    @PostMapping("/")
    public void createCar(@RequestBody BMW bmw) {
        service.createCar(bmw);
    }

    @PutMapping("/{regNumber}")
    public void updateCar(@PathVariable int regNUmber, @RequestBody BMW bmw) {
        service.updateCar(regNUmber, bmw);
    }


    @DeleteMapping("/{regNumber}")
    public void delete(@PathVariable int regNumber) {
        service.delete(regNumber);
    }


}
