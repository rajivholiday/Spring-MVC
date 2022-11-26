package com.example.Pro46.service;

import com.example.Pro46.entity.Student;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class StudentService {
    private final ArrayList<Student> students = new ArrayList<Student>();

    public void addStudent() {
        log.info("Creating Students");
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Tom");
        s1.setSurname("Brown");
        log.info("Student with name {} and with id {} created", s1.getName(), s1.getId());


        Student s2 = new Student();
        s2.setId(2);
        s2.setName("John");
        s2.setSurname("Terry");
        log.info("Student with name {} and with id {} created", s2.getName(), s2.getId());

        Student s3 =  new Student();
        s3.setId(3);
        s3.setName("Alice");
        s3.setSurname("Duke");
        log.info("Student with name {} and with id {} created", s3.getName(), s3.getId());


        students.add(s1);
        students.add(s2);
        students.add(s3);

    }


    public List<Student> getAll() {
        addStudent();
        log.info("Getting list of students");
        return students;

    }
}
