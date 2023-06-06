package com.example.springbootrestapidemo.dao;

import com.example.springbootrestapidemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createSelectionQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public Employee findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.createSelectionQuery("from Employee where id = :id", Employee.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        return session.merge(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.createMutationQuery("delete from Employee where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
