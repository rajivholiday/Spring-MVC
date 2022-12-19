package com.example.pro5_4.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j2
public class HTMLController {

    @GetMapping("/default")
    public ModelAndView handlerEx() {
        log.error("Exception occurred");
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.setStatus(HttpStatus.FORBIDDEN);
        return modelAndView;

    }

}
