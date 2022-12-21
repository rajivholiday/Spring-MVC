package com.example.pro5_4.service;

import com.example.pro5_4.entity.Student;
import com.example.pro5_4.exceptions.StudentNotFound;
import com.example.pro5_4.repository.StudentRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class StudentService {
    private final StudentRepo repo;


    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    public void create(Student student) {
        repo.save(student);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Optional<Student> getById(int id) {
        log.info("Student with id - {} was retrieved", id);
        return repo.findById(id);
    }

    public  void update(Student student){
        Student  student_from_db = getById(student.getId()).orElseThrow(StudentNotFound::new);
        student_from_db.setName(student.getName());
        student_from_db.setSurname(student.getSurname());
        repo.save(student_from_db);
    }
    public void deleteById(int id) {
        repo.deleteById(id);
        log.info("Student with id - {} was deleted", id);
    }

}