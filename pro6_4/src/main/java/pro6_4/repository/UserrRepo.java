package pro6_4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro6_4.entity.Userr;

import java.util.Optional;

@Repository
public interface UserrRepo extends JpaRepository<Userr, Integer> {
    Optional<Userr> findByUsername(String username);

}
