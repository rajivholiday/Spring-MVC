package com.example.pro5_10.controller;

import com.example.pro5_10.entity.MedicalCard;
import com.example.pro5_10.service.MedicalCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/m")
@Controller

public class MedicalCardController {
    private final MedicalCardService service;

    public MedicalCardController(MedicalCardService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MedicalCard>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalCard> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow());
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody MedicalCard medical_card) {
        return new ResponseEntity<>(service.create(medical_card), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody MedicalCard medical_card) {
        service.update(medical_card);
        return new ResponseEntity<>("Card was updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Card was deleted", HttpStatus.OK);
    }

}
