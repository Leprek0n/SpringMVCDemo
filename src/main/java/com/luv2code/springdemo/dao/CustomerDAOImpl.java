package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    public CustomerDAOImpl() {
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> getCustomerList() {
        List<Customer> resultList = entityManager.createQuery("SELECT u FROM Customer u", Customer.class).getResultList();
        return resultList;
    }

    @Transactional
    @Override
    public void save(Customer customer) {
        Customer customer1 = entityManager.merge(customer);
        entityManager.persist(customer1);
    }
}
