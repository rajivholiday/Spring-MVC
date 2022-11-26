package com.example.pro47.controller;

import com.example.pro47.entity.Worker;
import com.example.pro47.service.WorkerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/worker")
public class WorkerController {
    private  final WorkerService service;

    public WorkerController(WorkerService service) {
        this.service = service;
    }

    @PostMapping("/")
    public void create(@RequestBody Worker worker){
        service.create(worker);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Worker  worker){
        service.update(id, worker);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
