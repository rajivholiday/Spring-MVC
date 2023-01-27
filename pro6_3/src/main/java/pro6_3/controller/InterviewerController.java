package pro6_3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro6_3.entity.Interviewer;
import pro6_3.service.InterviewerService;
import pro6_3.dto.InterviewerRequest;

import java.util.List;

@Controller
@RequestMapping("/i")
public class InterviewerController {
    private final InterviewerService service;

    public InterviewerController(InterviewerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Interviewer>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interviewer> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Entity was deleted", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody InterviewerRequest interviewer) {
        return new ResponseEntity<>(service.create(interviewer), HttpStatus.CREATED);
//        return  ResponseEntity.ok(service.create(interviewer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody InterviewerRequest interviewer) {
        service.update(interviewer, id);
        return new ResponseEntity<>("Entity was updated", HttpStatus.OK);
    }
}
