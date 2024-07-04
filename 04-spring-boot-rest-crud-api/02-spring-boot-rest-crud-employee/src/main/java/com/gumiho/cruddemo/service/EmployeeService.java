package com.gumiho.cruddemo.service;

import com.gumiho.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee save(Employee theEmployee);

    Employee findById(int theId);

    void deleteById(int theId);
}
