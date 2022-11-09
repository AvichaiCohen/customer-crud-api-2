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
    public PollSystemResponse createPollSystem(PollSystemRequest pollSystemRequest) throws Exception {
        Customer selectedCustomer = pollSystemRequest.getCustomer();
        Customer customerForResponse = null;
        if(selectedCustomer != null){
            if(selectedCustomer.getId() != null ){
                Customer existingCustomer = customerService.getCustomerById(selectedCustomer.getId());
                if(existingCustomer != null){
                    // create new customer order and associate to the customer
                    pollSystemRepository.createPollSystem(pollSystemRequest.toCustomerOrder());
                    customerForResponse = existingCustomer;
                } else {
                    throw new Exception("Can't create customerOrder with non existing customer id " + selectedCustomer.getId());
                }
            } else {
                Long createdCustomerId = customerService.createCustomer(selectedCustomer);
                PollSystem pollSystemToCreate = pollSystemRequest.toCustomerOrder();
                pollSystemToCreate.setCustomerId(createdCustomerId);
                pollSystemRepository.createPollSystem(pollSystemToCreate);
                customerForResponse = customerService.getCustomerById(createdCustomerId);
            }
        } else {
            throw new Exception("Can't create customerOrder with customer as null");
        }
        List<PollSystem> pollSystemList = pollSystemRepository.getPollSystemByCustomerId(customerForResponse.getId());
        PollSystemResponse pollSystemResponse = pollSystemRequest.getCustomerOrder().toCustomerOrderResponse(customerForResponse, pollSystemList);
        return pollSystemResponse;
    }

    @Override
    public void updatePollSystemById(Long pollSystemId, PollSystem pollSystem) throws Exception {
        pollSystemRepository.updatePollSystemById(pollSystemId, pollSystem);

    }

    @Override
    public void deletePollSystemById(Long id) throws Exception {
        pollSystemRepository.deletePollSystemById(id);

    }

    @Override
    public PollSystem getPollSystemById(Long id) {
        return pollSystemRepository.getPollSystemById(id);
    }
}