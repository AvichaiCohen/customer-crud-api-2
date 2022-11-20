package com.customerService.model;

public class InternalPollQuestions {
    private Long customerId;

    public InternalPollQuestions(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}

