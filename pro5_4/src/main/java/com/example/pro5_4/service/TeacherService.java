package com.example.pro5_4.service;

import com.example.pro5_4.entity.Teacher;
import com.example.pro5_4.repository.TeacherRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class TeacherService {
    private final TeacherRepo repo;

    public TeacherService(TeacherRepo repo) {
        this.repo = repo;
    }
    public void create(Teacher teacher) {
        repo.save(teacher);
    }

    public List<Teacher> getAll() {
        return repo.findAll();
    }

    public Optional<Teacher> getById(int id) {
        log.info("Teacher with id - {} was retrieved", id);
        return repo.findById(id);
    }

    public  void update(Teacher teacher){
        Teacher  teacher_from_db = getById(teacher.getId()).orElseThrow();
        teacher_from_db.setName(teacher.getName());
        teacher_from_db.setSurname(teacher.getSurname());
        repo.save(teacher_from_db);
    }
    public void deleteById(int id) {
        repo.deleteById(id);
        log.info("Teacher with id - {} was deleted", id);

    }
}
