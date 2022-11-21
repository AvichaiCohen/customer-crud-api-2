package com.customerService.controller;


import com.customerService.model.Customer;
import com.customerService.service.CustomerService;
import com.customerService.service.InternalPollService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
@RequestMapping("/customer")

@RestController
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @Autowired
    private InternalPollService internalPollService;

    @PostMapping(value = "/create")
    public String createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return "Created";
    }

    @PutMapping(value = "/{customerId}/update")
    public void updateCustomerById(@PathVariable Long customerId,
                                   @RequestBody Customer customer) throws Exception{
        Customer existingCustomer = customerService.getCustomerById(customerId);
        if (existingCustomer != null) {
            customerService.updateCustomerById(customerId, customer);
        }
        else {
            throw new Error ("no such customer exist");
        }
    }

    @DeleteMapping(value = "/delete/{customerId}")
    public void deleteCustomerById(@PathVariable Long customerId) throws Exception {
        System.out.println("in Controller before delete method to Service");
        customerService.deleteCustomerById(customerId);
        System.out.println("in Controller after delete method to Service");
    }
    @GetMapping(value = "/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId)throws Exception{
        Customer existingCustomer = customerService.getCustomerById(customerId);
            if (existingCustomer == null) {
                System.out.println("in customer get method in if ");
                throw new Error("no such customer exist");
            }
        System.out.println("in customer get method");
        return existingCustomer;
    }

    @GetMapping(value = "/{firstName}/all")
    public List<Customer> getCustomersByFirstName(@PathVariable String firstName){
        return customerService.getCustomersByFirstName(firstName);
    }

    @GetMapping(value = "/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/customerId/{firstName}/all")
    public List<Long> getCustomerIdsByFirstName(@PathVariable String firstName){
        return customerService.getCustomerIdsByFirstName(firstName);
    }
}

