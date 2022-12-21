package com.example.pro5_6.controller;

import com.example.pro5_6.entity.Iphone;
import com.example.pro5_6.exceptions.PhoneNotCreated;
import com.example.pro5_6.service.IphoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/i")
public class IphoneController {
   private final IphoneService service;

    public IphoneController(IphoneService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Iphone iphone) {
        service.create(iphone);
        return new ResponseEntity<>("Phone was created", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Iphone>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Iphone> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow(PhoneNotCreated::new));
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Iphone iphone) {
        service.update(iphone);
        return new ResponseEntity<>("Phone was updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Phone was deleted", HttpStatus.OK);
    }
}
