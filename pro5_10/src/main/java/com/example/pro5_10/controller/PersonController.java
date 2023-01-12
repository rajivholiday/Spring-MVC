package com.example.pro5_10.controller;

import com.example.pro5_10.entity.Person;
import com.example.pro5_10.entity.Person_Record;
import com.example.pro5_10.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/p")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow());
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody Person person) {
        return new ResponseEntity<>(service.create1(person), HttpStatus.CREATED);
    }

    @PostMapping("/2")
    public ResponseEntity<Integer> create(@RequestBody Person_Record person) {
        return new ResponseEntity<>(service.create2(person), HttpStatus.CREATED);
    }

    @PostMapping("/common")
    public ResponseEntity<Integer> create_common(@RequestBody Person person) {
        return new ResponseEntity<>(service.common_create(person), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Person person) {
        service.update(person);
        return new ResponseEntity<>("Person was updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Person was deleted", HttpStatus.OK);
    }


}
