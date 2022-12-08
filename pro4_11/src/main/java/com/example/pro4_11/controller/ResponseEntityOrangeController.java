package com.example.pro4_11.controller;

import com.example.pro4_11.entity.Orange;
import com.example.pro4_11.service.OrangeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orange")
public class ResponseEntityOrangeController {
    private final OrangeService service;

    public ResponseEntityOrangeController(OrangeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Orange>> getAll() {
        List<Orange> all = service.getAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody Orange orange) {
        service.create(orange);
        return new ResponseEntity<>("Orange was created", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orange> getById(@PathVariable int id) {
        Orange orange = service.get(id).orElse(new Orange());
        return ResponseEntity.ok(orange);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Orange orange) {
        service.update(id, orange);
        return new ResponseEntity<>("Orange was updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Orange was deleted", HttpStatus.OK);
    }

}

