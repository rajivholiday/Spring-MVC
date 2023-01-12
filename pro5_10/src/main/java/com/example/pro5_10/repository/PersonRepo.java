package com.example.pro5_10.repository;

import com.example.pro5_10.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

}
