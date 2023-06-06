//package com.example.springbootrestapidemo.controller;
//
//import com.example.springbootrestapidemo.dao.EmployeeDao;
//import com.example.springbootrestapidemo.entity.Employee;
//import com.example.springbootrestapidemo.service.EmployeeService;
//import jakarta.persistence.NoResultException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class EmployeeController {
//    @Autowired
//    private EmployeeService employeeService;
//
//    @GetMapping("/employees")
//    public List<Employee> getEmployees() {
//        return employeeService.findAll();
//    }
//
//    @GetMapping("/employees/{id}")
//    public Employee getEmployee(@PathVariable("id") int id) {
//        Employee employee ;
//        try {
//            employee = employeeService.findById(id);
//        } catch (NoResultException e) {
//            throw new RuntimeException("Employee with id "+id+" not found");
//        }
//        return employee;
//    }
//
//    @PostMapping("/employees")
//    public Employee addEmployee(@RequestBody Employee employee) {
//        return employeeService.saveEmployee(employee);
//    }
//
//    @PutMapping("/employees")
//    public Employee updateEmployee(@RequestBody Employee employee) {
//        return employeeService.saveEmployee(employee);
//    }
//
//    @DeleteMapping("/employees/{id}")
//    public void deleteEmployee(@PathVariable("id") int id) {
//        employeeService.deleteEmployee(id);
//    }
//
//}
