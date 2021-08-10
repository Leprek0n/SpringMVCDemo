package com.luv2code.springdemo;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Main {
    @Autowired
    private static CustomerDAO customerDAO;
    public static void main(String[] args) {
        List<Customer> customers = customerDAO.getCustomerList();
        for(Customer customer: customers) {
            System.out.println(customer);
        }

    }
}
