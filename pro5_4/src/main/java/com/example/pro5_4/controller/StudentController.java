package com.example.pro5_4.controller;

import com.example.pro5_4.entity.Student;
import com.example.pro5_4.exceptions.StudentNotFound;
import com.example.pro5_4.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok((service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow(StudentNotFound::new));
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Student student) {
        service.create(student);
        return new ResponseEntity<>("Student was created", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Student student) {
        service.update(student);
        return new ResponseEntity<>("Student was updated", HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.deleteById(id);
        return new ResponseEntity<>("Student was deleted", HttpStatus.OK);
    }
}
