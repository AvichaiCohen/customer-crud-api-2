package com.customerService.controller;

import com.customerService.model.PollSystem;
import com.customerService.model.PollSystemRequest;
import com.customerService.model.PollSystemResponse;
import com.customerService.service.PollSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerOrderController {

    @Autowired
    private PollSystemService pollSystemService;

    @PostMapping(value = "/customerOrder/create")
    public PollSystemResponse createCustomerOrder(@RequestBody PollSystemRequest pollSystemRequest) throws Exception {
        return pollSystemService.createCustomerOrder(pollSystemRequest);
    }

    @PutMapping(value = "/customerOrder/{customerOrderId}/update")
    public void updateCustomerOrderById(@PathVariable Long customerOrderId,
                                        @RequestBody PollSystem pollSystem) throws Exception {
        pollSystemService.updateCustomerOrderById(customerOrderId, pollSystem);
    }

    @DeleteMapping(value = "/customerOrder/{customerOrderId}/delete")
    public void deleteCustomerOrderById(@PathVariable Long customerOrderId) throws Exception {
        pollSystemService.deleteCustomerOrderById(customerOrderId);
    }

    @GetMapping(value = "/customerOrder/{customerOrderId}")
    public PollSystem getCustomerOrderById(@PathVariable Long customerOrderId) {
        return pollSystemService.getCustomerOrderById(customerOrderId);
    }
}