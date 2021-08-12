package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getCustomerList();
    public void save(User user);
    public User showById(int id);
    public void update(User user, int id);
    public void delete( int id);
}
