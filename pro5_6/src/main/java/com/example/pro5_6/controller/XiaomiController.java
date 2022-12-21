package com.example.pro5_6.controller;

import com.example.pro5_6.entity.Xiaomi;
import com.example.pro5_6.exceptions.PhoneNotCreated;
import com.example.pro5_6.service.XiaomiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/x")
public class XiaomiController {
    private final XiaomiService service;

    public XiaomiController(XiaomiService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Xiaomi xiaomi) {
        service.create(xiaomi);
        return new ResponseEntity<>("Phone was created", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Xiaomi>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Xiaomi> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow(PhoneNotCreated::new));
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Xiaomi xiaomi) {
        service.update(xiaomi);
        return new ResponseEntity<>("Phone was updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Phone was deleted", HttpStatus.OK);
    }
}
