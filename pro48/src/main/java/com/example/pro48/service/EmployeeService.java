package com.example.pro48.service;

import com.example.pro48.entity.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class EmployeeService {
    private final ArrayList<Employee> employees = new ArrayList<Employee>();

    public List<Employee> getAll() {
        log.info("Getting the list of employees");
        return employees;

    }

    public Optional<Employee> getById(int id) {
        for (Employee employee : employees)
            if (employee.getId() == id) {
                return Optional.of(employee);
            }
        return Optional.empty();
    }

    public void create(Employee employee) {
        employees.add(employee);
        log.info("Employee was created");
    }

    public void update(int id, Employee employee) {
        for (Employee emp : employees)
            if (emp.getId() == id) {
                emp.setName(employee.getName());
                emp.setSurname(employee.getSurname());
                emp.setCompanyName(employee.getCompanyName());
                emp.setSalary(employee.getSalary());
                log.info("Employee with id number {} was updated", emp.getId());
            }
    }

    public void delete(int id) {
        for (Employee emp : employees)
            if (emp.getId() == id) {
                employees.remove(emp);
                break;
            }
        log.info("Employee was deleted");
    }
}