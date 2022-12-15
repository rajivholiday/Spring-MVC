package com.example.pro5_1.controller;

import com.example.pro5_1.entity.Azerbaijan;
import com.example.pro5_1.exceptions.CityNotCreatedException;
import com.example.pro5_1.exceptions.CityNotFoundException;
import com.example.pro5_1.service.AzerbaijanService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/az")
public class AzerbaijanController {
    private final AzerbaijanService service;


    public AzerbaijanController(AzerbaijanService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Azerbaijan>> getAll() {
        List<Azerbaijan> all = service.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Azerbaijan> getById(@PathVariable int id) {
        Azerbaijan az = service.getById(id).orElseThrow(CityNotFoundException::new);
        return ResponseEntity.ok(az);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Azerbaijan azerbaijan) {
        service.create(azerbaijan);
        return new ResponseEntity<>("City was created", HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Azerbaijan az) {
        service.update(id, az);
        return new ResponseEntity<>("Country was updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Country was deleted", HttpStatus.OK);
    }

}