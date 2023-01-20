package pro6_1.service;

import org.springframework.stereotype.Service;
import pro6_1.entity.Person;
import pro6_1.repository.PersonRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepo repo;

    public PersonService(PersonRepo repo) {
        this.repo = repo;
    }

    public List<Person> getAll() {
        return repo.findAll();
    }

    public Optional<Person> getById(int id) {
        return repo.findById(id);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    private Person setField(Person person) {
        person.setName(person.getName());
        person.setSurname(person.getSurname());
        person.setHouses(person.getHouses());
        return person;
    }
    public Integer createOrUpdate(Person person){
       return repo.save(person.getId() !=null ? setField(getById(person.getId()).orElseThrow()): person).getId();
}
    }