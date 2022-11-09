package com.customerService.service;

import com.customerService.model.Customer;
import com.customerService.model.PollSystem;
import com.customerService.model.PollSystemRequest;
import com.customerService.model.PollSystemResponse;
import com.customerService.repository.PollSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollSystemServiceImpl implements PollSystemService {

    @Autowired
    PollSystemRepository pollSystemRepository;

    @Autowired
    CustomerService customerService;


    @Override
    public PollSystemResponse createCustomerOrder(PollSystemRequest pollSystemRequest) throws Exception {
        Customer selectedCustomer = pollSystemRequest.getCustomer();
        Customer customerForResponse = null;
        if(selectedCustomer != null){
            if(selectedCustomer.getId() != null ){
                Customer existingCustomer = customerService.getCustomerById(selectedCustomer.getId());
                if(existingCustomer != null){
                    // create new customer order and associate to the customer
                    pollSystemRepository.createCustomerOrder(pollSystemRequest.toCustomerOrder());
                    customerForResponse = existingCustomer;
                } else {
                    throw new Exception("Can't create customerOrder with non existing customer id " + selectedCustomer.getId());
                }
            } else {
                Long createdCustomerId = customerService.createCustomer(selectedCustomer);
                PollSystem pollSystemToCreate = pollSystemRequest.toCustomerOrder();
                pollSystemToCreate.setCustomerId(createdCustomerId);
                pollSystemRepository.createCustomerOrder(pollSystemToCreate);
                customerForResponse = customerService.getCustomerById(createdCustomerId);
            }
        } else {
            throw new Exception("Can't create customerOrder with customer as null");
        }
        List<PollSystem> pollSystemList = pollSystemRepository.getCustomerOrdersByCustomerId(customerForResponse.getId());
        PollSystemResponse pollSystemResponse = pollSystemRequest.getCustomerOrder().toCustomerOrderResponse(customerForResponse, pollSystemList);
        return pollSystemResponse;
    }

    @Override
    public void updateCustomerOrderById(Long customerOrderId, PollSystem pollSystem) throws Exception {
        pollSystemRepository.updateCustomerOrderById(customerOrderId, pollSystem);

    }

    @Override
    public void deleteCustomerOrderById(Long id) throws Exception {
        pollSystemRepository.deleteCustomerOrderById(id);

    }

    @Override
    public PollSystem getCustomerOrderById(Long id) {
        return pollSystemRepository.getCustomerOrderById(id);
    }
}