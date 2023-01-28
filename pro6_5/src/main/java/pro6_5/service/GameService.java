package pro6_5.service;

import org.springframework.stereotype.Service;
import pro6_5.dto.GameRequest;
import pro6_5.entity.Game;
import pro6_5.exceptions.GameNotFound;
import pro6_5.repository.GameRepo;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepo repo;

    public GameService(GameRepo repo) {
        this.repo = repo;
    }
    public List<Game> getAll(){
        return  repo.findAll();
    }
    public Optional<Game> getById(Integer id){
        return  repo.findById(id);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
    public Integer create(GameRequest request){
        return  repo.save(fieldSetter(new Game(), request)).getId();
    }
    public void update(GameRequest request, Integer id){
        fieldSetter(getById(id).orElseThrow(GameNotFound::new), request);
    }
    private  Game fieldSetter(Game db_game, GameRequest request){
        db_game.setName(request.name());
        db_game.setType(request.type());
        db_game.setUserrs(request.userrs());
        return db_game;
    }
}
