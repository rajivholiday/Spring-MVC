package pro6_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro6_5.entity.Game;

public interface GameRepo extends JpaRepository<Game, Integer> {
}
