package new_projects.les3_11.service;

import new_projects.les3_11.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    public Student getById(int id) {
        List<Student> students = new ArrayList<>();
        Student s1 = new Student("Tom", "White", 1);
        Student s2 = new Student("Sarah", "Brown", 2);
        students.add(s1);
        students.add(s2);
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

}
