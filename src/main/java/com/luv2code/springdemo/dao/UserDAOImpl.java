package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO {

    public UserDAOImpl() {
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getCustomerList() {
        List<User> resultList = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        return resultList;
    }

    @Transactional
    @Override
    public void save(User user) {
        User user1 = entityManager.merge(user);
        entityManager.persist(user1);
    }

    @Override
    public User showById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void update(User user, int id) {
        User user1 = entityManager.find(User.class, id);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        entityManager.persist(user1);
    }

    @Override
    @Transactional
    public void delete(User user, int id) {
        User user1 = entityManager.find(User.class, id);
        entityManager.remove(user1);
    }
}
