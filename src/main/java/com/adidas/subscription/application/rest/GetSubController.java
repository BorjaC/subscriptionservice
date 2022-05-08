package com.adidas.subscription.application.rest;


import com.adidas.subscription.application.response.SubscriptionResponse;
import com.adidas.subscription.application.rest.mapper.SubscriptionApiMapper;
import com.adidas.subscription.domain.repository.SubscriptionRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Get details of a subscription controller.
 *
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "subscriptions")
@RequestMapping("/subscriptions")
public class GetSubController {

    private final SubscriptionApiMapper mapper;
    private final SubscriptionRepository repository;

    /**
     * Get details of a subscription.
     *
     * @param id subscription id.
     * @return
     *  - 200 get details of a subscription.
     *  - 500 internal error server (unexpected error).
     */
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get details of a subscription.")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public SubscriptionResponse findById(@RequestHeader("Authorization") String authorization,
                                         @PathVariable("id") Long id) {
        return mapper.toResponse(repository.findById(id));
    }

}
