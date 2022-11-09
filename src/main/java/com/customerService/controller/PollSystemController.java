package com.customerService.controller;

import com.customerService.model.PollSystem;
import com.customerService.model.PollSystemRequest;
import com.customerService.model.PollSystemResponse;
import com.customerService.service.PollSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PollSystemController {

    @Autowired
    private PollSystemService pollSystemService;

    @PostMapping(value = "/pollSystem/create")
    public PollSystemResponse createpollSystem(@RequestBody PollSystemRequest pollSystemRequest) throws Exception {
        return pollSystemService.createCustomerOrder(pollSystemRequest);
    }

    @PutMapping(value = "/pollSystem/{customerOrderId}/update")
    public void updateCustomerOrderById(@PathVariable Long customerOrderId,
                                        @RequestBody PollSystem pollSystem) throws Exception {
        pollSystemService.updateCustomerOrderById(customerOrderId, pollSystem);
    }

    @DeleteMapping(value = "/pollSystem/{customerOrderId}/delete")
    public void deleteCustomerOrderById(@PathVariable Long customerOrderId) throws Exception {
        pollSystemService.deleteCustomerOrderById(customerOrderId);
    }

    @GetMapping(value = "/pollSystem/{customerOrderId}")
    public PollSystem getCustomerOrderById(@PathVariable Long customerOrderId) {
        return pollSystemService.getCustomerOrderById(customerOrderId);
    }
}