package com.gumiho.cruddemo.dao;

import com.gumiho.cruddemo.entity.Employee;
import com.gumiho.cruddemo.service.EmployeeService;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee save(Employee theEmployee);

    Employee findById(int theId);

    void deleteById(int theId);
}