package com.customerService.controller;

import com.customerService.service.InternalPollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollController {

    @Autowired
    private InternalPollService internalPollService;

    @DeleteMapping(value = "/delete/pollAnswers/{customerId}")
    public void deleteAnswersById(@PathVariable Long customerId){
        System.out.println("before delete internal");
        internalPollService.deleteAnswersById(customerId);
        System.out.println("after delete internal");
    }
}
