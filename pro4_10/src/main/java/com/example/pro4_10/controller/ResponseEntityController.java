package com.example.pro4_10.controller;

import com.example.pro4_10.entity.User;
import com.example.pro4_10.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/u")
public class ResponseEntityController {
    private final UserService service;
    public ResponseEntityController(UserService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> handler2(){
        List<User> all = service.getAll();
       return  ResponseEntity.ok(all);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<String> handler3(@PathVariable int id){
        service.delete(id);
        return new ResponseEntity<>("User was deleted", HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> handler4(@PathVariable int id, @RequestBody User user){
        service.update(id, user);
        return new ResponseEntity<>("User was updated", HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<String> create(@RequestBody User user){
        service.create(user);
        return new ResponseEntity<>("User was created", HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable int id){
       User user = service.getById(id).orElse(new User());
       return ResponseEntity.ok(user);

    }



}
