package pro6_1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro6_1.entity.Person;
import pro6_1.service.PersonService;

import java.util.List;

@Controller
@RequestMapping("/p")
public class PersonController {
    private final PersonService service;


    public PersonController(PersonService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow());
    }

    @PutMapping
    public ResponseEntity<Integer> createOrUpdate(@RequestBody Person person) {
        return  ResponseEntity.ok(service.createOrUpdate(person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Entity was deleted", HttpStatus.OK);
    }

}
