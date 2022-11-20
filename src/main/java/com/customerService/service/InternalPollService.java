package com.customerService.service;

import com.customerService.model.InternalPollQuestions;
import com.customerService.repository.InternalPollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
public class InternalPollService {

    @Autowired
    InternalPollRepository internalPollRepository;
    @Autowired
    InternalPollQuestions internalPollQuestions;


    @FeignClient(
            name = "InternalPollService",
            url = "${externalApi.pollService.url}"
    )
    public class InternalCustomerService {
        @DeleteMapping(value = "/delete/{customerId}")
        String getCustomerId(@PathVariable Long customer_Id) {
            internalPollRepository.deleteCustomerById(customer_Id);
        return "Deleted";
        }
    }
}
