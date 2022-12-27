package com.example.pro5_7.service;

import com.example.pro5_7.entity.Employee;
import com.example.pro5_7.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepo repo;


    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public int create(Employee employee) {
        return repo.save(employee).getId();
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Optional<Employee> getById(int id) {
        return repo.findById(id);
    }

    public void update(Employee employee) {
        Employee employee1 = getById(employee.getId()).orElseThrow();
        employee1.setName(employee.getName());
        employee1.setSurname(employee.getSurname());
        employee1.setSalary(employee.getSalary());
        employee1.setDocument(employee.getDocument());
        repo.save(employee1);
    }

    public void delete(int id) {
        repo.deleteById(id);

    }
}
