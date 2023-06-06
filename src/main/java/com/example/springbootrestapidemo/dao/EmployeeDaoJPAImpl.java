package com.example.springbootrestapidemo.dao;

import com.example.springbootrestapidemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoJPAImpl implements EmployeeDao {
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDaoJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("SELECT e from Employee e", Employee.class).getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.createQuery("SELECT e from Employee e where e.id = :id", Employee.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        entityManager.remove(entityManager.find(Employee.class, id));
    }
}
