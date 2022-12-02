package com.example.pro4_10.controller;

import com.example.pro4_10.entity.User;
import com.example.pro4_10.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/")
    public void create(@RequestBody User user) {
        service.create(user);
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable int id){
        return service.getById(id).orElse(new User());
    }
    @GetMapping("/")
    public List<User> getAll(){
        return service.getAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody User user) {
        service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
