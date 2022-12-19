package com.example.pro5_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectController {
    @GetMapping("/rd")
    public RedirectView handler(@RequestParam(required = false) String choose) {
        return switch (choose) {
            case null -> new RedirectView("/common");
            case "teacher" -> new RedirectView("/teacher");
            case "student" -> new RedirectView("/student");
            default -> new RedirectView("/default");
        };
    }
}
