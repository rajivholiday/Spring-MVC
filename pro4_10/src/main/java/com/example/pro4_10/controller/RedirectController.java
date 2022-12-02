package com.example.pro4_10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/redirect")
    public String handlerByName(){
        return "redirect:/u/1";
    }
}
