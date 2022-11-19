package com.example.Car_new.controller;

import com.example.Car_new.entity.Mercedes;
import com.example.Car_new.service.MercedesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mercedes")
public class MercedesController {
    private final MercedesService service;

    public MercedesController(MercedesService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Mercedes> getAll() {
        return service.getAll();
    }

    @GetMapping("/{regNumber}")
    public Mercedes getById(@PathVariable int regNumber) {
        return service.getById(regNumber);
    }

    @PostMapping("/")
    public void createCar(@RequestBody Mercedes car) {
        service.createCar(car);
    }

//    @PostMapping("/")
//    public void create(@RequestParam int regNumber,
//                       @RequestParam String color,
//                       @RequestParam String engineType,
//                       @RequestParam long milaege) {
//        service.create(regNumber, color, engineType, milaege);
//
//    }

    @PutMapping("/regNumber")
    public void update(@PathVariable int regNumber, @RequestBody Mercedes mercedes) {
        service.updateCar(regNumber, mercedes);
    }

    @DeleteMapping("/regNumber")
    public void delete(@PathVariable int regNumber) {
        service.delete(regNumber);
    }
}
