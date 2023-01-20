package pro5_12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro5_12.entity.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
}
