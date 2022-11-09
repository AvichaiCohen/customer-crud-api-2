package com.customerService.model;

import java.util.List;

public class PollSystemResponse {
    private Customer customer;
    private List<PollSystem> pollSystems;

    public PollSystemResponse(Customer customer, List<PollSystem> pollSystems) {
        this.customer = customer;
        this.pollSystems = pollSystems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<PollSystem> getCustomerOrders() {
        return pollSystems;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomerOrders(List<PollSystem> pollSystems) {
        this.pollSystems = pollSystems;
    }
}
