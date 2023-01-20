package pro5_12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro5_12.entity.Person;

@Repository
public interface PersonRepo  extends JpaRepository<Person, Long> {


}
