package com.customerService.service;

import com.customerService.model.PollSystem;
import com.customerService.model.PollSystemRequest;
import com.customerService.model.PollSystemResponse;

public interface PollSystemService {
    PollSystemResponse createPollSystem(PollSystemRequest pollSystemRequest) throws Exception;
    void updatePollSystemById(Long pollSystemId, PollSystem pollSystem) throws Exception;
    void deletePollSystemById(Long id) throws Exception;
    PollSystem getPollSystemById(Long id);
}