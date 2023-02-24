package pro6_2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro6_2.entity.Car;
import pro6_2.service.CarService;
import pro6_2.dto.CarDto;

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
        return ResponseEntity.ok(service.getById(id).orElseThrow());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Entity was deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody CarDto car) {
        service.update(car, id);
        return new ResponseEntity<>("Entity was updated", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody CarDto car) {
        return new ResponseEntity<>(service.create(car), HttpStatus.CREATED);
    }
}
