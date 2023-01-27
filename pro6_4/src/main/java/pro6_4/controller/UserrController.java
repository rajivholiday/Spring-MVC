package pro6_4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro6_4.dto.UserrLogin;
import pro6_4.dto.UserrRequest;
import pro6_4.entity.Userr;
import pro6_4.service.UserrService;

import java.util.List;

@Controller
@RequestMapping("/u")
public class UserrController {
    private final UserrService service;

    public UserrController(UserrService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Userr>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Userr> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow());
    }

    @PostMapping("/register")
    public ResponseEntity<Integer> create(@RequestBody UserrRequest request) {
        return ResponseEntity.ok(service.create_registration(request));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> create(@RequestBody UserrLogin login) {
        Integer userId = service.login(login);
        return userId == null ? new ResponseEntity<>("Username or Password is wrong", HttpStatus.UNAUTHORIZED)
                : ResponseEntity.ok(userId);
    }

}
