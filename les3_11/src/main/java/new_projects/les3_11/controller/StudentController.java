package new_projects.les3_11.controller;

import new_projects.les3_11.entity.Student;
import new_projects.les3_11.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final StudentService service;


    public StudentController(StudentService service) {
        this.service = service;
    }
    @RequestMapping("/user/1")
    public Student getStudent1(){
        return service.getById(1);
    }
    @RequestMapping("/user/2")
    public Student getStudent2(){
        return service.getById(2);
    }

}
