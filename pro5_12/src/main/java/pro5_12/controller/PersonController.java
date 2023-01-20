package pro5_12.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro5_12.entity.Person;
import pro5_12.service.PersonService;

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
    public ResponseEntity<Person> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow());
    }

    @PutMapping
    public ResponseEntity<Long> createOrUpdate(@RequestBody Person person) {
        return new ResponseEntity<>(service.updateOrCreate(person), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>("Entity was deleted", HttpStatus.OK);
    }

}
