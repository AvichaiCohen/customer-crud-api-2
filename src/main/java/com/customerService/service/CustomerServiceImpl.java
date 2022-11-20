package com.customerService.service;

import com.customerService.model.Customer;
import com.customerService.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Long createCustomer(Customer customer) throws Exception {
            return customerRepository.createCustomer(customer);
    }

    @Override
    public void updateCustomerById(Long customerId, Customer customer) throws Exception {
        Customer existingCustomer =  customerRepository.getCustomerById(customerId);
        if(existingCustomer != null){
            customerRepository.updateCustomerById(customerId, customer);
        } else {
            throw new Exception("The customer id: " + customerId + " is not existing, so we can't delete it");
        }
    }

    @Override
    public void deleteCustomerById(Long id) throws Exception {
        Customer existingCustomer =  customerRepository.getCustomerById(id);
        if(existingCustomer != null){
            customerRepository.deleteCustomerById(id);
        } else {
            throw new Exception("The customer id: " + id + " is not existing, so we can't delete it");
        }
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> getCustomersByFirstName(String firstName) {
        return customerRepository.getCustomersByFirstName(firstName);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public List<Long> getCustomerIdsByFirstName(String firstName) {
        return customerRepository.getCustomerIdsByFirstName(firstName);
    }
}
