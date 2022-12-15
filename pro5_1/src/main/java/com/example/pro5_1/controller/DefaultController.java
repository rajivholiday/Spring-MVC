package com.example.pro5_1.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j2
public class DefaultController {

    @GetMapping("/default")
    public ModelAndView handlerEx() {
        log.error("Exception is caught");
        ModelAndView modelAndView = new ModelAndView("exception");
        modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return modelAndView;
    }
}
