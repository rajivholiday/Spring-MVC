package com.example.pro47.fullController;

import com.example.pro47.entity.Worker;
import com.example.pro47.service.WorkerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@Log4j2
@Controller
@RequestMapping("/worker")
public class WorkerController1 {
    private final WorkerService service;


    public WorkerController1(WorkerService service) {
        this.service = service;
    }

    @PostMapping("/")
    @ResponseBody
    public void create(@RequestBody Worker worker) {
        service.create(worker);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public void update(@PathVariable int id, @RequestBody Worker worker) {
        service.update(id, worker);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/")
    public String getAll(Model model) {
        List<Worker> all = service.getAll();
        model.addAttribute("worker", all);
        return "worker.html";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id, Model model) {
        Worker worker = service.getById(id);
        model.addAttribute("worker", worker);
        return "workerid.html";
    }
    @GetMapping("/default")
    public String handler(){
        log.error("Page not found");
        return "default.html";
    }


}
