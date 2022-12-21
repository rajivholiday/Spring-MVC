package com.example.pro5_6.controller;

import com.example.pro5_6.entity.Samsung;
import com.example.pro5_6.exceptions.PhoneNotCreated;
import com.example.pro5_6.service.SamsungService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/s")
public class SamsungController {
    private final SamsungService service;

    public SamsungController(SamsungService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Samsung samsung) {
        service.create(samsung);
        return new ResponseEntity<>("Phone was created", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Samsung>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Samsung> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow(PhoneNotCreated::new));
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Samsung samsung) {
        service.update(samsung);
        return new ResponseEntity<>("Phone was updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Phone was deleted", HttpStatus.OK);
    }
}
