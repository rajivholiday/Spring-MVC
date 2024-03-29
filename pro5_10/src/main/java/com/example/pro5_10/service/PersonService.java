package com.example.pro5_10.service;

import com.example.pro5_10.dto.PersonDto;
import com.example.pro5_10.entity.MedicalCard;
import com.example.pro5_10.entity.Person;
import com.example.pro5_10.repository.MedicalCardRepo;
import com.example.pro5_10.repository.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepo repo;
    private final MedicalCardRepo card_repo;


    public PersonService(PersonRepo repo, MedicalCardRepo card_repo) {
        this.repo = repo;
        this.card_repo = card_repo;

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

    public Integer create2(PersonDto person) {
        Person p = new Person();
        p.setName(person.name());
        p.setSurname(person.surname());
        p.setSalary(person.salary());

        MedicalCard medical_card = card_repo.findById(person.docId()).orElseThrow();
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
