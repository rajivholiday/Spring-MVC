package pro6_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro6_5.entity.Userr;

import java.util.Optional;

@Repository
public interface UserrRepo extends JpaRepository<Userr, Integer> {
    Optional<Userr> findByUsername(String username);
}