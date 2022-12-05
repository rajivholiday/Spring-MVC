package com.example.pro4_11.controller;

import com.example.pro4_11.entity.Seller;
import com.example.pro4_11.service.SellerService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/seller")
public class ResponseEntitySellerController {
    private final SellerService service;

    public ResponseEntitySellerController(SellerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Seller>> getAll() {
        List<Seller> all = service.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> getById(@PathVariable int id) {
        Seller seller = service.getById(id).orElse(new Seller());
        return ResponseEntity.ok(seller);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Seller seller) {
        service.create(seller);
        return new ResponseEntity<>("Seller was created", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Seller seller) {
        service.update(id, seller);
        return new ResponseEntity<>("Seller was updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Seller was deleted", HttpStatus.OK);
    }

}
