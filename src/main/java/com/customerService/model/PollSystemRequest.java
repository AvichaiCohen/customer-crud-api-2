package com.customerService.model;

public class PollSystemRequest {
    private Customer customer;
    private PollSystem pollSystem;

    public PollSystemRequest(Customer customer, PollSystem pollSystem) {
        this.customer = customer;
        this.pollSystem = pollSystem;
    }

    public Customer getCustomer() {
        return customer;
    }

    public PollSystem getCustomerOrder() {
        return pollSystem;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomerOrder(PollSystem pollSystem) {
        this.pollSystem = pollSystem;
    }

    // building the CustomerOrder DTO
    public PollSystem toCustomerOrder(){
        return new PollSystem(
                this.pollSystem.getId(),
                this.customer.getId(),
                this.pollSystem.getItemName(),
                this.pollSystem.getPrice(),
                this.pollSystem.getCurrency()
        );
    }
}