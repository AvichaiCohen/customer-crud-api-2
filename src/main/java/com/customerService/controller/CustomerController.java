package com.customerService.controller;


import com.customerService.model.Customer;
import com.customerService.repository.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.IMessageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HttpCodeStatusMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.net.http.HttpRequest;
import java.sql.Date;
import java.util.List;
@RequestMapping("/customer")

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(value = "/create")
    public String createCustomer(@RequestBody Customer customer) {
        customerRepository.createCustomer(customer);
        return "Created";
    }

    @PutMapping(value = "/{customerId}/update")
    public void updateCustomerById(@PathVariable Long customerId,
                                   @RequestBody Customer customer) throws Exception{
        Customer existingCustomer = customerRepository.getCustomerById(customerId);
        if (existingCustomer != null) {
            customerRepository.updateCustomerById(customerId, customer);
        }
        else {
            throw new Error ("no such customer exist");
        }
    }

    @DeleteMapping(value = "/{customerId}/delete")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public String deleteCustomerById(@PathVariable Long customerId) throws Exception {
        Customer existingCustomer = customerRepository.getCustomerById(customerId);
        if (existingCustomer != null) {
            customerRepository.deleteCustomerById(customerId);
        }
        else {
            throw new Error ("no such customer exist");
        }
        return "Customer Deleted";
    }
    @GetMapping(value = "/{customerId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Customer getCustomerById(@PathVariable Long customerId)throws Exception{
        Customer existingCustomer = customerRepository.getCustomerById(customerId);
            if (existingCustomer == null) {
                System.out.println("in customer get method in if ");
                throw new Error("no such customer exist");
            }
        System.out.println("in customer get method");
        return existingCustomer;
    }

    @GetMapping(value = "/{firstName}/all")
    public List<Customer> getCustomersByFirstName(@PathVariable String firstName){
        return customerRepository.getCustomersByFirstName(firstName);
    }

    @GetMapping(value = "/all")
    public List<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    @GetMapping(value = "/customerId/{firstName}/all")
    public List<Long> getCustomerIdsByFirstName(@PathVariable String firstName){
        return customerRepository.getCustomerIdsByFirstName(firstName);
    }
}

