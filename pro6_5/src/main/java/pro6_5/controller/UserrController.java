package pro6_5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro6_5.dto.GameRequest;
import pro6_5.dto.UserLogin;
import pro6_5.dto.UserrRequest;
import pro6_5.entity.Userr;
import pro6_5.exceptions.UserNotCreated;
import pro6_5.service.UserrService;

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
        return ResponseEntity.ok(service.getById(id).orElseThrow(UserNotCreated::new));
    }

    @PostMapping("/register")
    public ResponseEntity<Integer> create(@RequestBody UserrRequest request) {
        return ResponseEntity.ok(service.create_registration(request));
    }

    @PostMapping("/login")
    public ResponseEntity<Integer> login(@RequestBody UserLogin login) {
        return ResponseEntity.ok(service.login(login));
//        Integer userId = service.login(login);
////        return userId == null ? new ResponseEntity<>("Username or password is wrong", HttpStatus.UNAUTHORIZED)
////                : ResponseEntity.ok(userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>("Entity was deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody UserrRequest request, @PathVariable Integer id) {
        service.update(request, id);
        return new ResponseEntity<>("Entity was updated", HttpStatus.OK);
    }
}
