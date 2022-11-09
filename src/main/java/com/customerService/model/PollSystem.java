package com.customerService.model;

import java.util.List;

public class PollSystem {
    private Long id;
    private Long customerId;
    private String itemName;
    private Long price;
    private PollSystemFirstQuestion currency;

    public PollSystem(Long id, Long customerId, String itemName, Long price, PollSystemFirstQuestion currency) {
        this.id = id;
        this.customerId = customerId;
        this.itemName = itemName;
        this.price = price;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getItemName() {
        return itemName;
    }

    public Long getPrice() {
        return price;
    }

    public PollSystemFirstQuestion getCurrency() {
        return currency;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setCurrency(PollSystemFirstQuestion currency) {
        this.currency = currency;
    }

    public PollSystemResponse toCustomerOrderResponse(Customer customer, List<PollSystem> pollSystemList){
        return new PollSystemResponse(
                customer,
                pollSystemList
        );
    }
}
