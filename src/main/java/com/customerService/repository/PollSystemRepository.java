package com.customerService.repository;

import com.customerService.model.PollSystem;

import java.util.List;

public interface PollSystemRepository {
    void createPollSystem(PollSystem pollSystem) throws Exception;
    void updatePollSystemById(Long pollSystemId, PollSystem pollSystem) throws Exception;
    void deletePollSystemById(Long id) throws Exception;
    PollSystem getPollSystemById(Long id);
    List<PollSystem> getPollSystemByCustomerId(Long customerId);
}
