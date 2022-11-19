package com.example.Car.controller;

import com.example.Car.entity.Mercedes;
import com.example.Car.service.MercedesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mercedes")
public class MercedesController {
    private final MercedesService service;

    public MercedesController(MercedesService service) {
        this.service = service;
    }

    @RequestMapping("/create")
    public Mercedes create(@RequestParam int regNumber, @RequestParam String color, @RequestParam String engineType,
                           @RequestParam long mileage) {
        return service.create(regNumber, color, engineType, mileage);
    }

    @GetMapping("/get/{regNumber}")
    public Mercedes get(@PathVariable int regNumber) {
        return service.get(regNumber);
    }

    @RequestMapping("/update/{regNumber}")
    public Mercedes update(@PathVariable int regNumber, @RequestParam String color, @RequestParam String engineType,
                           @RequestParam long mileage) {
        return service.update(regNumber, color, engineType, mileage);
    }

    @RequestMapping("/delete/{regNumber}")
    public String delete(@PathVariable int regNumber) {
        return service.delete(regNumber);
    }

}
