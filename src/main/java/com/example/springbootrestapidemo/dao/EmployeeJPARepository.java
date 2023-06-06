package com.example.springbootrestapidemo.dao;

import com.example.springbootrestapidemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "congtam")
public interface EmployeeJPARepository extends JpaRepository<Employee, Integer> {

}
