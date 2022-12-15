package com.example.pro5_1.controller;

import com.example.pro5_1.entity.Turkey;
import com.example.pro5_1.exceptions.CityNotFoundException;
import com.example.pro5_1.service.TurkeyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tr")
public class TurkeyController {
    private final TurkeyService service;

    public TurkeyController(TurkeyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Turkey>> getAll() {
        List<Turkey> all = service.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turkey> getById(@PathVariable int id) {
        Turkey tr = service.getById(id).orElseThrow(CityNotFoundException::new);
        return ResponseEntity.ok(tr);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Turkey turkey) {
        service.create(turkey);
        return new ResponseEntity<>("City was created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Turkey turkey) {
        service.update(id, turkey);
        return new ResponseEntity<>("City was update", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("City was deleted", HttpStatus.OK);
    }

}
