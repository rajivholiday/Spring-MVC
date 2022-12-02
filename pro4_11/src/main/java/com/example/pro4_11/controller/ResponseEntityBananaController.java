package com.example.pro4_11.controller;

import com.example.pro4_11.entity.Apple;
import com.example.pro4_11.entity.Banana;
import com.example.pro4_11.service.BananaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/banana")
public class ResponseEntityBananaController {
    private final BananaService service;
    public ResponseEntityBananaController(BananaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Banana>> getAll() {
        List<Banana> all = service.getAll();
        return ResponseEntity.ok(all);
    }
    @PostMapping()
    public ResponseEntity<String> create(@RequestBody Banana banana){
        service.create(banana);
        return  new ResponseEntity<>("Banana was created", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banana> getById(@PathVariable int id) {
        Banana banana = service.get(id).orElse(new Banana());
        return ResponseEntity.ok(banana);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Banana was updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Banana was deleted", HttpStatus.OK);
    }
}
