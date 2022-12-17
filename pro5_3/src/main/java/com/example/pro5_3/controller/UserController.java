package com.example.pro5_3.controller;

import com.example.pro5_3.entity.Userss;
import com.example.pro5_3.exception.UserNotFound;
import com.example.pro5_3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService service;


    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Userss>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Userss> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(service.getUserById(id).orElseThrow(UserNotFound::new));
    }

    @PostMapping("/")
    public ResponseEntity<Object> createUser(@RequestBody Userss user) {
        service.create_User(user);
        return new ResponseEntity<>("User was created", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> updateUserById(@RequestBody Userss user) {
        service.updateUserById(user);
        return new ResponseEntity<>("User was update", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable int id) {
        service.deleteUserById(id);
        return new ResponseEntity<>("User was deleted", HttpStatus.OK);
    }

}
