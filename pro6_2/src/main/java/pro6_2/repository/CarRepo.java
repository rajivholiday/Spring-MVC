package pro6_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro6_2.entity.Car;

public interface CarRepo extends JpaRepository<Car, Integer> {
}
