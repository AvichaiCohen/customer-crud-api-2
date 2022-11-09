package com.customerService.service;

import com.customerService.model.PollSystem;
import com.customerService.model.PollSystemRequest;
import com.customerService.model.PollSystemResponse;

public interface PollSystemService {
    PollSystemResponse createCustomerOrder(PollSystemRequest pollSystemRequest) throws Exception;
    void updateCustomerOrderById(Long customerOrderId, PollSystem pollSystem) throws Exception;
    void deleteCustomerOrderById(Long id) throws Exception;
    PollSystem getCustomerOrderById(Long id);
}