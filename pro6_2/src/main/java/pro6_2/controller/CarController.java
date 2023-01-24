package pro6_2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro6_2.entity.Car;
import pro6_2.service.CarService;

import java.util.List;

@Controller
@RequestMapping("/c")
public class CarController {
    private  final CarService service;


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

    @PutMapping("/")
    public ResponseEntity<String> update(@RequestBody Car car) {
        service.update(car);
        return new ResponseEntity<>("Entity was updated", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody Car car) {
        return new ResponseEntity<>(service.create(car), HttpStatus.CREATED);
    }
}
