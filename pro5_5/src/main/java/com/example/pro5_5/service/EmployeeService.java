package com.example.pro5_5.service;

import com.example.pro5_5.entity.Employee;
import com.example.pro5_5.repository.EmployeeRepo;
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
        Employee employee1 = repo.save(employee);
        return employee1.getId();
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Optional<Employee> getById(int id) {
        return repo.findById(id);
    }

    public void update(Employee employee) {
        Employee emp = getById(employee.getId()).orElseThrow();
        emp.setName(employee.getName());
        emp.setSurname(employee.getSurname());
        emp.setCompanyName(employee.getCompanyName());
        emp.setSalary(employee.getSalary());
        repo.save(emp);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
