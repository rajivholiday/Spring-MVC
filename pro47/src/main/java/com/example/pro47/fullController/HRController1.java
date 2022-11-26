package com.example.pro47.fullController;

import com.example.pro47.entity.HR;
import com.example.pro47.service.HRService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hr/full")
@Log4j2
public class HRController1 {
    private final HRService service;

    public HRController1(HRService service) {
        this.service = service;
    }

    @PostMapping("/")
    @ResponseBody
    public void create(@RequestBody HR hr) {
        service.create(hr);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public void update(@PathVariable int id, @RequestBody HR hr) {
        service.update(id, hr);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @RequestMapping("/hrr")
    public String getAll(Model model) {
        List<HR> all = service.getAll();
        model.addAttribute("hr", all);
        return "hr.html";
    }

    @RequestMapping("/{id}")
    public String getById(@PathVariable int id, Model model) {
        HR hr = service.getById(id);
        model.addAttribute("hr", hr);
        return "hr_id.html";
    }

    @RequestMapping("/default")
    public String handler() {
        log.error("Page not found");
        return "default.html";
    }
}
