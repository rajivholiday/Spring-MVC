package com.example.pro4_11.controller;

import com.example.pro4_11.entity.Apple;
import com.example.pro4_11.service.AppleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/apple")

public class ResponseEntityAppleController {
    private final AppleService service;
    public ResponseEntityAppleController(AppleService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Apple>> getAll() {
        List<Apple> all = service.getAll();
        return ResponseEntity.ok(all);
    }
    @PostMapping()
    public ResponseEntity<String> create(@RequestBody Apple apple){
         service.create(apple);
         return  new ResponseEntity<>("Apple was created", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apple> getById(@PathVariable int id){
        Apple apple =  service.get(id).orElse(new Apple());
        return ResponseEntity.ok(apple);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<String> update(@PathVariable int id, @RequestBody Apple apple){
        service.update(id,apple);
        return new ResponseEntity<>("Apple was updated", HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>delete(@PathVariable int id){
        service.delete(id);
        return new ResponseEntity<>("Apple was deleted", HttpStatus.OK);
    }
}
