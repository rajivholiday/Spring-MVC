package new_projects.les3_12.controller;

import new_projects.les3_12.entity.Dog;
import new_projects.les3_12.service.DogService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dog")
public class DogController {
    private final DogService service;

    public DogController(DogService service) {
        this.service = service;
    }

    @RequestMapping("/getall")
    public List<Dog> dogGetAll() {
        return service.dogGetAll();
    }

    @RequestMapping("/get/{d_id}")
    public Dog dogById(@PathVariable(name = "d_id") int id) {
        return service.dogById(id);
    }


}
