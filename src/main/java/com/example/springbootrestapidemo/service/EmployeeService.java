package com.example.springbootrestapidemo.service;

import com.example.springbootrestapidemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(int id);
}
