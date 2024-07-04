package com.gumiho.cruddemo.dao;

import com.gumiho.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    //defind field for entitymanager
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();
        // return the results
        return employees;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee newEmployee = entityManager.merge(theEmployee);
        return newEmployee;
    }

    @Override
    public Employee findById(int theId) {

        // get Employee
        Employee findEmployee = entityManager.find(Employee.class,theId);

        // return employee
        return findEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee deleteEmployee = entityManager.find(Employee.class,theId);
        entityManager.remove(deleteEmployee);

    }
}
