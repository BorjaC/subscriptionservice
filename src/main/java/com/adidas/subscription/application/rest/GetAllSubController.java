package com.adidas.subscription.application.rest;


import com.adidas.subscription.application.response.SubscriptionResponse;
import com.adidas.subscription.application.rest.mapper.SubscriptionApiMapper;
import com.adidas.subscription.domain.repository.SubscriptionRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Get all subscriptions controller.
 *
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "subscriptions")
@RequestMapping("/subscriptions")
public class GetAllSubController {

    private final SubscriptionApiMapper mapper;
    private final SubscriptionRepository repository;

    /**
     * Get all subscriptions.
     *
     * @return
     *  - 200 get all subscriptions.
     *  - 500 internal error server (unexpected error).
     */
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get all subscriptions.")
    @RequestMapping(method = RequestMethod.GET)
    public List<SubscriptionResponse> findAll(@RequestHeader("Authorization") String authorization) {
        return mapper.toResponse(repository.findAll());
    }

}
