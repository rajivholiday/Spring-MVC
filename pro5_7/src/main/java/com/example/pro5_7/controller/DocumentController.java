package com.example.pro5_7.controller;

import com.example.pro5_7.entity.Document;
import com.example.pro5_7.entity.Employee;
import com.example.pro5_7.service.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doc")
public class DocumentController {
    private final DocumentService service;

    public DocumentController(DocumentService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Document>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow());
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Document document) {
        service.create(document);
        return new ResponseEntity<>("Document was created", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> updateById(@RequestBody Document document) {
        service.update(document);
        return new ResponseEntity<>("Document was updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Document was deleted", HttpStatus.OK);
    }
}


