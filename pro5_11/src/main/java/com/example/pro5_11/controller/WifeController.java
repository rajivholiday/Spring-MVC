package com.example.pro5_11.controller;

import com.example.pro5_11.entity.Wife;
import com.example.pro5_11.exceptions.NoSuchEntityFound;
import com.example.pro5_11.service.WifeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/w")
public class WifeController{
    private final WifeService service;

    public WifeController(WifeService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Wife>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Wife> getById(@PathVariable int id){
        return ResponseEntity.ok(service.getById(id).orElseThrow(NoSuchEntityFound::new));
    }
    @PostMapping("/common")
    public ResponseEntity<Integer> commonCreate(@RequestBody Wife wife){
        return new ResponseEntity<>(service.create(wife), HttpStatus.CREATED);
    }

    @PutMapping
    public  ResponseEntity<Object> update(@RequestBody Wife wife){
        service.update(wife);
        return  new ResponseEntity<>("Entity was updated", HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id){
        service.delete(id);
        return  new ResponseEntity<>("Entity was deleted", HttpStatus.OK);
    }
}

