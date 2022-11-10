package com.customerService.tvMaze;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "tvMazeService",
        url = "https://api.tvmaze.com"
)
public interface TvMazeService {
    @GetMapping(path = "/shows/{tvShowId}")
    TvMazeShowResponse getTvShowById(@PathVariable Long tvShowId);
}
