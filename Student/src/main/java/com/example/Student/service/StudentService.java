package com.example.Student.service;

import com.example.Student.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public List<Student> getAll() {
        return students;
    }

    public Student getById(int id) {
        for (Student s : students)
            if (s.getId() == id) {
                return s;
            }
        return null;
    }

    public void create(Student student) {
        students.add(student);
    }

    public void update(int id, Student student){
        for(Student s: students)
            if(s.getId() == id){
                s.setName(student.getName());
                s.setSurname(student.getSurname());
            }
    }

    public void delete(int id) {
        for (Student s : students)
            if (s.getId() == id) {
                students.remove(s);
                break;
            }
    }
}
