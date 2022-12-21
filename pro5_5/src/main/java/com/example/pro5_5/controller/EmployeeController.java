package com.example.pro5_5.controller;

import com.example.pro5_5.entity.Employee;
import com.example.pro5_5.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow());
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Employee employee) {
        service.create(employee);
        return new ResponseEntity<>("Employee was created", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> updateById(@RequestBody Employee employee) {
        service.update(employee);
        return new ResponseEntity<>("Employee was updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Employee was deleted", HttpStatus.OK);
    }
}
