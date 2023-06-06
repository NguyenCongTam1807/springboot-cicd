package com.example.springbootrestapidemo.dao;

import com.example.springbootrestapidemo.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee findById(int id);
    Employee saveEmployee(Employee customer);
    void deleteEmployee(int id);
}
