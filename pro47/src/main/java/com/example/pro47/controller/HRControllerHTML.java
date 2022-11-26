package com.example.pro47.controller;

import com.example.pro47.entity.HR;
import com.example.pro47.service.HRService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/html")
public class HRControllerHTML {
    private final HRService service;

    public HRControllerHTML(HRService service) {
        this.service = service;
    }

    @RequestMapping("/hr")
    public String handler(Model model) {
        List<HR> all = service.getAll();
        model.addAttribute("HR", all);
        return "hr.html";
    }

    @RequestMapping("/{id}")
    public String getById(@PathVariable int id, Model model) {
        HR hr = service.getById(id);
        model.addAttribute("hr", hr);
        return "hr_id.html";

    }

}
