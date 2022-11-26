package com.example.pro47.controller;

import com.example.pro47.entity.Worker;
import com.example.pro47.service.WorkerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Log4j2
@Controller
public class WorkerControllerHTML {
    private final WorkerService service;

    public WorkerControllerHTML(WorkerService service) {
        this.service = service;
    }
    @RequestMapping("/worker")
    public String handler(Model model){
        List<Worker> all = service.getAll();
        model.addAttribute("workers", all);
        return "worker.html";
    }

    @RequestMapping("/worker/{id}")
    public String getById( @PathVariable int id,Model model){
        Worker worker = service.getById(id);
        model.addAttribute("worker", worker);
        return "workerid.html";
    }

    @RequestMapping("/default")
    public String handler1(){
        log.error("Page not found");
        return "default.html";
    }

}
