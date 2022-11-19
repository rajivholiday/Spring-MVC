package new_projects.les3_12.controller;

import new_projects.les3_12.entity.Parrot;
import new_projects.les3_12.service.ParrotService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parrot")
public class ParrotController {
    private final ParrotService service;

    public ParrotController(ParrotService service) {
        this.service = service;
    }

    @RequestMapping("/getall")
    public List<Parrot> parrotGetAll() {
        return service.parrotGetAll();
    }

    @RequestMapping("/get/{p_id}")
    public Parrot getById(@PathVariable(name = "p_id") int id) {
        return service.parrotById(id);
    }


}
