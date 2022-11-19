package new_projects.les3_12.controller;

import new_projects.les3_12.entity.Cat;
import new_projects.les3_12.service.CatService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cat")
public class CatController {
    private final CatService service;

    public CatController(CatService service) {
        this.service = service;
    }

    @RequestMapping("/getall")
    public List<Cat> catGetAll() {
        return service.catGetAll();
    }

    @RequestMapping("/get/{c_id}")
    public Cat getByID(@PathVariable(name = "c_id") int id) {
        return service.catById(id);
    }
}
