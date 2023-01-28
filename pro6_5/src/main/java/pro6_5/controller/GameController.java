package pro6_5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro6_5.dto.GameRequest;
import pro6_5.dto.UserLogin;
import pro6_5.dto.UserrRequest;
import pro6_5.entity.Game;
import pro6_5.entity.Userr;
import pro6_5.exceptions.GameNotCreated;
import pro6_5.exceptions.UserNotCreated;
import pro6_5.service.GameService;

import java.util.List;

@Controller
@RequestMapping("/g")
public class GameController {
    private  final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Game>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id).orElseThrow(GameNotCreated::new));
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody GameRequest request) {
        return ResponseEntity.ok(service.create(request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        service.delete(id);
        return new ResponseEntity<>("Entity was deleted", HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody GameRequest request, @PathVariable Integer id){
        service.update( request, id);
        return new ResponseEntity<>("Entity was updated", HttpStatus.OK);
    }
}
