package pro5_12.service;

import org.springframework.stereotype.Service;
import pro5_12.entity.Person;
import pro5_12.repository.CarRepo;
import pro5_12.repository.PersonRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepo personRepo;
    private final CarRepo carRepo;


    public PersonService(PersonRepo personRepo, CarRepo carRepo) {
        this.personRepo = personRepo;
        this.carRepo = carRepo;
    }

    public List<Person> getAll() {
        return personRepo.findAll();
    }

    public Optional<Person> getById(Long id) {
        return personRepo.findById(id);
    }

    public void delete(Long id) {
        personRepo.deleteById(id);
    }

    public Long updateOrCreate(Person person) {
        Person person1;
        if (person.getId() != null)
            person1 = setField(getById(person.getId()).orElseThrow());
        else
            person1 = person;
        return personRepo.save(person1).getId();
    }
    private Person setField(Person person) {
        person.setName(person.getName());
        person.setSurname(person.getSurname());
        person.setPassNumber(person.getPassNumber());
        person.setCars(person.getCars());
        return person;
    }
//
//    public Long updateOrCreate(Person person) {
//        Person person1 = new Person();
//        if (person.getId() != null) {
//            person1.setName(person.getName());
//            person1.setSurname(person.getSurname());
//            person1.setPassNumber(person.getPassNumber());
//            person1.setCars(person.getCars());
//        }
//        else person1 = person;
//        return personRepo.save(person1).getId();
    }
