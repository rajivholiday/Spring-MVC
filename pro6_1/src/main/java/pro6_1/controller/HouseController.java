package pro6_1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro6_1.entity.House;
import pro6_1.service.HouseService;

import java.util.List;

@Controller
@RequestMapping("/h")
public class HouseController {
    private final HouseService service;


    public HouseController(HouseService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<House>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<House> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow());
    }

    @PutMapping
    public ResponseEntity<Object> createOrUpdate(@RequestBody House house) {
        service.createOrUpdate(house);
        return new ResponseEntity<>("Entity was updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Entity was deleted", HttpStatus.OK);
    }

}
