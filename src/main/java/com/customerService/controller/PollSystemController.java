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
        return pollSystemService.createPollSystem(pollSystemRequest);
    }

    @PutMapping(value = "/pollSystem/{pollSystemId}/update")
    public void updatePollSystemById(@PathVariable Long pollSystemId,
                                        @RequestBody PollSystem pollSystem) throws Exception {
        pollSystemService.updatePollSystemById(pollSystemId, pollSystem);
    }

    @DeleteMapping(value = "/pollSystem/{pollSystemId}/delete")
    public void deletePollSystemById(@PathVariable Long pollSystemId) throws Exception {
        pollSystemService.deletePollSystemById(pollSystemId);
    }

    @GetMapping(value = "/pollSystem/{pollSystemId}")
    public PollSystem getPollSystemById(@PathVariable Long pollSystemId) {
        return pollSystemService.getPollSystemById(pollSystemId);
    }
}