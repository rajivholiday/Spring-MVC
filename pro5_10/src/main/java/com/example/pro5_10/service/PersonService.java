package com.example.pro5_10.service;

import com.example.pro5_10.entity.Medical_Card;
import com.example.pro5_10.entity.Person;
import com.example.pro5_10.entity.Person_Record;
import com.example.pro5_10.repository.Medical_Card_Repo;
import com.example.pro5_10.repository.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepo repo;
    private final Medical_Card_Repo card_repo;
    private final Medical_Card_Service service;

    public PersonService(PersonRepo repo, Medical_Card_Repo card_repo, Medical_Card_Service service) {
        this.repo = repo;
        this.card_repo = card_repo;
        this.service = service;
    }


    public List<Person> getAll() {
        return repo.findAll();
    }

    public Optional<Person> getById(int id) {
        return repo.findById(id);
    }

    public void update(Person person) {
        Person p = getById(person.getId()).orElseThrow();
        p.setName(person.getName());
        p.setSurname(person.getSurname());
        p.setSalary(person.getSalary());
        repo.save(p);
    }

    public int create1(Person person) {
        return repo.save(person).getId();
    }

    public Integer create2(Person_Record person) {
        Person p = new Person();
        p.setName(person.name());
        p.setSurname(person.surname());
        p.setSalary(person.salary());

        Medical_Card medical_card = card_repo.findById(person.docId()).orElseThrow();
        p.setMedical_card(medical_card);
        return repo.save(p).getId();
    }

    public Integer common_create(Person person) {
        Person person1 = new Person();
        person1.setName(person.getName());
        person1.setSurname(person.getSurname());
        person1.setSalary(person.getSalary());

        if (person.getMedical_card() != null && person.getMedical_card().getId() != null)
            person1.setMedical_card(card_repo.findById(person.getMedical_card().getId()).orElseThrow());
        else person1.setMedical_card(person.getMedical_card());
        return repo.save(person1).getId();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
