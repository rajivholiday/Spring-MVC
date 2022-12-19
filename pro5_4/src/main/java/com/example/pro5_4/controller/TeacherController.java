package com.example.pro5_4.controller;

import com.example.pro5_4.entity.Teacher;
import com.example.pro5_4.exceptions.TeacherNotFound;
import com.example.pro5_4.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService service;


    public TeacherController(TeacherService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Teacher>> getAll() {
        return ResponseEntity.ok((service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow(TeacherNotFound::new));
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Teacher teacher) {
        service.create(teacher);
        return new ResponseEntity<>("Teacher was created", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Teacher teacher) {
        service.update(teacher);
        return new ResponseEntity<>("Teacher was updated", HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.deleteById(id);
        return new ResponseEntity<>("Teacher was deleted", HttpStatus.OK);
    }
}
