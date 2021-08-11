package com.luv2code.springdemo;

import com.luv2code.springdemo.dao.UserDAO;
import com.luv2code.springdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Main {
    @Autowired
    private static UserDAO userDAO;
    public static void main(String[] args) {
        List<User> users = userDAO.getCustomerList();
        for(User user : users) {
            System.out.println(user);
        }

    }
}
