package com.example.Car_new.controller;

import com.example.Car_new.entity.Volvo;
import com.example.Car_new.service.VolvoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volvo")
public class VolvoController {
    private final VolvoService service;

    public VolvoController(VolvoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Volvo> getAll() {
        return service.getAll();
    }

    @GetMapping("/{regNumber}")
    public Volvo getById(@PathVariable int regNumber) {
        return service.getById(regNumber);
    }

    @PostMapping("/")
    public void createCar(@RequestBody Volvo volvo) {
        service.createCar(volvo);
    }

//    @PostMapping("/create")
//    public void create(@RequestParam int regNumber,
//                       @RequestParam String color,
//                       @RequestParam String engineType,
//                       @RequestParam long mileage) {
//        service.create(regNumber, color, engineType, mileage);
//    }

    @PutMapping("/")
    public void updateCar(@PathVariable int regNumber, @RequestBody Volvo volvo) {
        service.updateCar(regNumber, volvo);
    }

    @DeleteMapping("/{regNumber}")
    public void delete(@PathVariable int regNumber) {
        service.delete(regNumber);
    }
}
