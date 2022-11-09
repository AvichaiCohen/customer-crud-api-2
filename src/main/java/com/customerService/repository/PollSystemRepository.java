package com.customerService.repository;

import com.customerService.model.PollSystem;

import java.util.List;

public interface PollSystemRepository {
    void createCustomerOrder(PollSystem pollSystem) throws Exception;
    void updateCustomerOrderById(Long customerOrderId, PollSystem pollSystem) throws Exception;
    void deleteCustomerOrderById(Long id) throws Exception;
    PollSystem getCustomerOrderById(Long id);
    List<PollSystem> getCustomerOrdersByCustomerId(Long customerId);
}
