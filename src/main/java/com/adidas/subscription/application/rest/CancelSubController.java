package com.adidas.subscription.application.rest;


import com.adidas.subscription.domain.repository.SubscriptionRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Cancel a subscription controller.
 *
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "subscriptions")
@RequestMapping("/subscriptions")
public class CancelSubController {

    private final SubscriptionRepository repository;

    /**
     * Cancel a subscription.
     *
     * @param id subscription id.
     * @return
     *  - 200 cancelled (a subscription was cancelled).
     *  - 500 internal error server (unexpected error).
     */
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Cancel a subscription.")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void cancel(@RequestHeader("Authorization") String authorization,
                       @PathVariable("id") Long id) {
        repository.cancel(id);
    }

}
