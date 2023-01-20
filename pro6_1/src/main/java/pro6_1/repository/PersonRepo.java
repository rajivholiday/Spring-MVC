package pro6_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro6_1.entity.Person;
@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

}
