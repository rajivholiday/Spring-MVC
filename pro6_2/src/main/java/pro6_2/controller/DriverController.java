package pro6_2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro6_2.entity.Driver;
import pro6_2.dto.DriverRequest;
import pro6_2.service.DriverService;

import java.util.List;

@Controller
@RequestMapping("/d")
public class DriverController {
    private final DriverService service;


    public DriverController(DriverService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Driver>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Entity was deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody DriverRequest driver) {
        service.update(driver, id);
        return new ResponseEntity<>("Entity was updated", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody DriverRequest driver) {
        return new ResponseEntity<>(service.create(driver), HttpStatus.CREATED);
    }
}
