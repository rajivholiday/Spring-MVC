package com.example.pro5_9.service;

import com.example.pro5_9.entity.Person;
import com.example.pro5_9.repository.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepo repo;

    public PersonService(PersonRepo repo) {
        this.repo = repo;
    }

    public int create(Person person) {
        return repo.save(person).getId();
    }

    public List<Person> getAll() {
        return repo.findAll();
    }

    public Optional<Person> getById(int id) {
        return repo.findById(id);
    }

    public void update(Person person) {
        Person person1 = getById(person.getId()).orElseThrow();
        person1.setName(person.getName());
        person1.setSurname(person.getSurname());
        repo.save(person1);

    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
