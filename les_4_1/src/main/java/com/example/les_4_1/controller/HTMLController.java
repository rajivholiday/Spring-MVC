package com.example.les_4_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HTMLController {

    @RequestMapping("/cat/default")
    public String handler1() {
        return "index.html";
    }

    @RequestMapping("/dog/default")
    public String handler2() {
        return "error.html";
    }

}
