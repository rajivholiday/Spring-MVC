package com.example.Car.controller;

import com.example.Car.entity.Volvo;
import com.example.Car.service.VolvoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/volvo")
public class VolvoController {
    private final VolvoService service;

    public VolvoController(VolvoService service) {
        this.service = service;
    }

    @RequestMapping("/create")
    public Volvo create(@RequestParam int regNumber, @RequestParam String color, @RequestParam String engineType,
                        @RequestParam long mileage) {
        return service.create(regNumber, color, engineType, mileage);
    }

    @GetMapping("/get/{regNumber}")
    public Volvo get(@PathVariable int regNumber) {
        return service.get(regNumber);
    }

    @RequestMapping("/update/{regNumber}")
    public Volvo update(@PathVariable int regNumber, @RequestParam String color, @RequestParam String engineType,
                        @RequestParam long mileage) {
        return service.update(regNumber, color, engineType, mileage);
    }

    @RequestMapping("/delete/{regNumber}")
    public String delete(@PathVariable int regNumber) {
        return service.delete(regNumber);
    }

}
