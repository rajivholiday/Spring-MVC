package com.example.pro5_4.controller;

import com.example.pro5_4.entity.Student;
import com.example.pro5_4.entity.Teacher;
import com.example.pro5_4.service.StudentService;
import com.example.pro5_4.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class CommonController {
    private final StudentService s_service;
    private final TeacherService t_service;


    public CommonController(StudentService s_service, TeacherService t_service) {
        this.s_service = s_service;
        this.t_service = t_service;
    }

    @GetMapping("/common")
    public ResponseEntity<List<Object>> common() {
        List<Student> students = s_service.getAll();
        List<Teacher> teachers = t_service.getAll();
        List<Object> common = new ArrayList<>();
        common.addAll(students);
        common.addAll(teachers);
        return ResponseEntity.ok(common);
    }

}
