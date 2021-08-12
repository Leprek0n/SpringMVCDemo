package com.luv2code.springdemo.service;

import com.luv2code.springdemo.dao.UserDAO;
import com.luv2code.springdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getCustomerList() {
        return userDAO.getCustomerList();
    }

    @Override
    public void save(User user) {
        userDAO.save(user);

    }

    @Override
    public User showById(int id) {
        return userDAO.showById(id);
    }

    @Override
    public void update(User user, int id) {
        userDAO.update(user, id);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }
}
