package com.example.pro5_11.controller;

import com.example.pro5_11.entity.Husband;
import com.example.pro5_11.exceptions.EntityNotCreated;
import com.example.pro5_11.service.HusbandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/h")
public class HusbandController {
    private final HusbandService service;

    public HusbandController(HusbandService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Husband>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Husband> getById(@PathVariable int id){
        return ResponseEntity.ok(service.getById(id).orElseThrow(EntityNotCreated::new));
    }
    @PostMapping("/common")
    public ResponseEntity<Integer> commonCreate(@RequestBody Husband husband){
        return new ResponseEntity<>(service.createCommon(husband), HttpStatus.CREATED);
    }

    @PutMapping
    public  ResponseEntity<Object> update(@RequestBody Husband husband){
        service.update(husband);
        return  new ResponseEntity<>("Husband was updated", HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id){
        service.delete(id);
        return  new ResponseEntity<>("Husband was deleted", HttpStatus.OK);
    }
}
