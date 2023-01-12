package com.example.pro5_10.controller;

import com.example.pro5_10.entity.Medical_Card;
import com.example.pro5_10.service.Medical_Card_Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/m")
@Controller

public class Medical_Card_Controller {
    private final Medical_Card_Service service;

    public Medical_Card_Controller(Medical_Card_Service service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Medical_Card>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medical_Card> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow());
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody Medical_Card medical_card) {
        return new ResponseEntity<>(service.create(medical_card), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Medical_Card medical_card) {
        service.update(medical_card);
        return new ResponseEntity<>("Card was updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Card was deleted", HttpStatus.OK);
    }

}
