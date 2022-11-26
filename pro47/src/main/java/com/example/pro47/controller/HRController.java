package com.example.pro47.controller;

import com.example.pro47.entity.HR;
import com.example.pro47.service.HRService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hr")
public class HRController {
    private final HRService service;

    public HRController(HRService service) {
        this.service = service;
    }

    @PostMapping("/")
    public void create(@RequestBody HR hr) {
        service.create(hr);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody HR hr) {
        service.update(id, hr);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
