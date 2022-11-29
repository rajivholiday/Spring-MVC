package com.example.pro49.controller;

import com.example.pro49.entity.User;
import com.example.pro49.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping("/")
    public String handler1(Model model) {
        List<User> all = service.getAll();
        model.addAttribute("users", all);
        return "user.html";
    }

    @GetMapping("/{id}")
    public String handler2(@PathVariable int id, Model model) {
        User u = service.getById(id).orElse(new User());
        model.addAttribute("users", u);
        return "u.html";

    }

    @GetMapping("/age/{age}")
    public String handler3(@PathVariable int age, Model model) {
        List<User> all = service.getByAge(age);
        model.addAttribute("us", all);
        return "us.html";
    }


    @GetMapping("/email/{email}")
    public String handler4(@PathVariable String email, Model model) {
        User u = service.getByEmail(email).orElse(new User());
        model.addAttribute("users", u);
        return "userbyemail.html";

    }

    @ResponseBody
    @PostMapping("/")
    public void create(@RequestBody User user) {
        service.create(user);
    }
}