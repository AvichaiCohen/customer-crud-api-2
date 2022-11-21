package com.customerService.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

    @FeignClient(
            name = "InternalPollService",
            url = "${externalApi.pollService.url}"
    )
    public interface InternalPollService {
        @DeleteMapping(value = "/pollService/delete/{customerId}")
        void deleteAnswersById(@PathVariable Long customerId);
    }

