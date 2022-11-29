package com.example.pro48.controller;

import com.example.pro48.entity.Employee;
import com.example.pro48.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;


    @PostMapping("/")
    public void create(@RequestBody Employee employee) {
        service.create(employee);
    }

    @GetMapping("/{id}")
    Employee getById(@PathVariable int id) {
        return service.getById(id).orElse(new Employee());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Employee employee) {
        service.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }


}
