package com.tw.core.service;

import com.tw.core.Customer;
import com.tw.core.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jiaoming on 6/30/15.
 */
@Service
public class CustomerService {
    private CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO){
        this.customerDAO=customerDAO;
    }

    @Transactional
    public List<Customer> listCustomer(){
        return customerDAO.listCustomer();
    }

    @Transactional
    public void addCustomer(Customer customer){
        customerDAO.addCustomer(customer);
    }

    @Transactional
    public Customer findCustomerById(long id){
        return customerDAO.findCustomerById(id);
    }

    @Transactional
    public void updateCustomer(Customer customer){
        customerDAO.updateCustomer(customer);
    }

    @Transactional
    public void deleteCustomer(long id){
        customerDAO.deleteCustomer(id);
    }




}
