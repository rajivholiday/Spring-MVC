package pro6_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro6_2.entity.Driver;

public interface DriverRepo extends JpaRepository<Driver, Integer> {
}
