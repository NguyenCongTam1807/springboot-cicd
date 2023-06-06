package com.example.springbootrestapidemo.service;

import com.example.springbootrestapidemo.dao.EmployeeDao;
import com.example.springbootrestapidemo.dao.EmployeeJPARepository;
import com.example.springbootrestapidemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;
    private EmployeeJPARepository repository;

//    @Autowired
//    public EmployeeServiceImpl(@Qualifier("employeeDaoJPAImpl") EmployeeDao employeeDao) {
//        this.employeeDao = employeeDao;
//    }

    @Autowired
    public EmployeeServiceImpl(EmployeeJPARepository repository) {
        this.repository = repository;
    }

    //@Transactional
    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    //@Transactional
    @Override
    public Employee findById(int id) {
        Optional<Employee> optionalEmployee;
        if ((optionalEmployee = repository.findById(id)).isPresent()) {
            return optionalEmployee.get();
        } else return new Employee();
    }

    //@Transactional
    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    //@Transactional
    @Override
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }

//    @Override
//    @Transactional
//    public List<Employee> findAll() {
//        return employeeDao.findAll();
//    }
//
//    @Override
//    @Transactional
//    public Employee findById(int id) {
//        return employeeDao.findById(id);
//    }
//
//    @Override
//    @Transactional
//    public Employee saveEmployee(Employee customer) {
//        return employeeDao.saveEmployee(customer);
//    }
//
//    @Override
//    @Transactional
//    public void deleteEmployee(int id) {
//        employeeDao.deleteEmployee(id);
//    }
}
