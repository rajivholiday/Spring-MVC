package com.example.pro5_1.controller;

import com.example.pro5_1.entity.Russia;
import com.example.pro5_1.exceptions.CityNotFoundException;
import com.example.pro5_1.service.RussiaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ru")
public class RussiaController {
    private final RussiaService service;


    public RussiaController(RussiaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Russia>> getAll() {
        List<Russia> all = service.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Russia> getById(@PathVariable int id) {
        Russia ru = service.getById(id).orElseThrow(CityNotFoundException::new);
        return ResponseEntity.ok(ru);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Russia russia) {
        service.create(russia);
        return new ResponseEntity<>("City was created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Russia russia) {
        service.update(id, russia);
        return new ResponseEntity<>("City was update", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("City was deleted", HttpStatus.OK);
    }
}

