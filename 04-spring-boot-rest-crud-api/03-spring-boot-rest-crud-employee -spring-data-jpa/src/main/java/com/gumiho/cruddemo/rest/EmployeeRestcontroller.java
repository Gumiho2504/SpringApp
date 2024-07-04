package com.gumiho.cruddemo.rest;

import com.gumiho.cruddemo.entity.Employee;
import com.gumiho.cruddemo.respone.EmployeeNotFoundException;
import com.gumiho.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestcontroller {

    // quick and dirty : inject employee dao (use constructor injection
    //private EmployeeDAO employeeDAO;
    private EmployeeService employeeService;
    public EmployeeRestcontroller(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    // expose "/employee" and return a list of employee
    @GetMapping("/employee")
    public List<Employee> findAllEmployee(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee findEmployeeById(@PathVariable int employeeId){
        Employee dbEmployee = employeeService.findById(employeeId);
        if(dbEmployee == null){
            throw new EmployeeNotFoundException("Employee id not found - " + employeeId);
        }
        return dbEmployee;
    }

    // Add employee for POST / employee - add new Employee
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // also just in case they pass an id in JSON ...Set id to 0
        // this is to force a save of new item ... instead of update
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // add mapping to PUT / employee - update existing employee
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return  dbEmployee;
    }

    // add mapping to DELETE / employee
    @DeleteMapping("/employee/{employeeId}")
    public String deletEmployee(@PathVariable int employeeId){
        Employee dbEmpoyee = employeeService.findById(employeeId);
        if(dbEmpoyee == null){
            throw new RuntimeException("Employee not found " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Employee have been delete - id =  " + employeeId;
    }

}
