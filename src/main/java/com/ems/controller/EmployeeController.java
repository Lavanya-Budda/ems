package com.ems.controller;

import com.ems.entity.Employee;
import com.ems.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("/addemp")
    public Employee addEmp(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

    @GetMapping("/getemp")
    public List<Employee> getEmp() {
        return employeeRepo.findAll();
    }

    @GetMapping("/getbyid/{empId}")
    public List<Employee> getById(@PathVariable("empId") Long empId) {
        List<Employee> employees = employeeRepo.findByEmpId(empId);

//        Employee employee = employeeRepo.findByEmpId(empId);
        // employees.add(employee);
        return employees;
    }

    @GetMapping("/getbyname/{name}")
    public List<Employee> getByName(@PathVariable("name") String name) {

        return employeeRepo.findByEmpName(name);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmp(@PathVariable("id") String id) {
        return (Employee) employeeRepo.findAllById(id);
    }

    @DeleteMapping("/deleteemp/{empId}")
    public String deleteEmp(@PathVariable("empId") Long empId) {
        String s = employeeRepo.deleteById(empId);
        return s;
    }
}
