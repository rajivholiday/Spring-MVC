package pro6_3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro6_3.entity.Applicant;
import pro6_3.service.ApplicantService;
import pro6_3.dto.ApplicantRequest;

import java.util.List;

@Controller
@RequestMapping("/a")
public class ApplicantController {
    private final ApplicantService service;

    public ApplicantController(ApplicantService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Applicant>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Applicant> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>("Entity was deleted", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody ApplicantRequest applicant) {
        return new ResponseEntity<>(service.create(applicant), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody ApplicantRequest applicant) {
        service.update(applicant, id);
        return new ResponseEntity<>("Entity was updated", HttpStatus.OK);
    }
}
