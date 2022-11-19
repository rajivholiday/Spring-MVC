package com.example.Student.controller;

import com.example.Student.entity.Student;
import com.example.Student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/{s_id}")
    public Student getById(@PathVariable(name = "s_id") int id) {
        return service.getById(id);
    }

    @PostMapping("/")
    public void create(@RequestBody Student student) {
        service.create(student);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Student student) {
        service.update(id, student);
    }

    @DeleteMapping("/{s_id}")
    public void delete(@PathVariable(name = "s_id") int id) {
        service.delete(id);
    }

}
