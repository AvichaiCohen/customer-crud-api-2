package com.customerService.model;

import java.util.List;

public class PollSystem {
    private Long id;
    private Long customerId;

    private PollSystemFirstQuestion firstQuestion;

    private PollSystemSecondQuestion secondQuestion;

    private PollSystemThirdQuestion thirdQuestion;

    private PollSystemFourthQuestion fourthQuestion;


    public PollSystem(Long id, Long customerId, PollSystemFirstQuestion firstQuestion, PollSystemSecondQuestion secondQuestion, PollSystemThirdQuestion thirdQuestion, PollSystemFourthQuestion fourthQuestion) {
        this.id = id;
        this.customerId = customerId;
        this.firstQuestion = firstQuestion;
        this.secondQuestion = secondQuestion;
        this.thirdQuestion = thirdQuestion;
        this.fourthQuestion = fourthQuestion;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public PollSystemFirstQuestion getFirstQuestion() {
        return firstQuestion;
    }

    public PollSystemSecondQuestion getSecondQuestion() {
        return secondQuestion;
    }

    public PollSystemThirdQuestion getThirdQuestion() {
        return thirdQuestion;
    }

    public PollSystemFourthQuestion getFourthQuestion() {
        return fourthQuestion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setFirstQuestion(PollSystemFirstQuestion firstQuestion) {
        this.firstQuestion = firstQuestion;
    }

    public void setSecondQuestion(PollSystemSecondQuestion secondQuestion) {
        this.secondQuestion = secondQuestion;
    }

    public void setThirdQuestion(PollSystemThirdQuestion thirdQuestion) {
        this.thirdQuestion = thirdQuestion;
    }

    public void setFourthQuestion(PollSystemFourthQuestion fourthQuestion) {
        this.fourthQuestion = fourthQuestion;
    }

    public PollSystemResponse toCustomerOrderResponse(Customer customer, List<PollSystem> pollSystemList){
        return new PollSystemResponse(
                customer,
                pollSystemList
        );
    }
}
