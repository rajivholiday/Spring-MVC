package com.example.pro5_1.controller;

import com.example.pro5_1.service.AzerbaijanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller

public class RedirectController {
    @GetMapping("/getCities")
    public RedirectView handler(@RequestParam String country) {
        return switch (country) {
            case "Azerbaijan" -> new RedirectView("/az");
            case "Turkey" -> new RedirectView("/tr");
            case "Russia" -> new RedirectView("/ru");
            default -> new RedirectView("https://yahoo.com/");
        };
    }
}
