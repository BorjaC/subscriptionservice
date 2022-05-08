package com.adidas.subscription.application.rest;


import com.adidas.subscription.application.request.SubscriptionRequest;
import com.adidas.subscription.application.rest.mapper.SubscriptionApiMapper;
import com.adidas.subscription.domain.usecase.CreateSubscriptionUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Create new subscription controller.
 *
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "subscriptions")
@RequestMapping("/subscriptions")
public class CreateSubController {

    private final SubscriptionApiMapper mapper;
    private final CreateSubscriptionUseCase useCase;

    /**
     * Create new subscription.
     *
     * @param request request to create new subscription.
     * @return
     *  - 201 created (new subscription created).
     *  - 400 bad request.
     *  - 500 internal error server (unexpected error).
     */
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create new subscription.")
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public long create(@RequestHeader("Authorization") String authorization,
                       @Valid @RequestBody SubscriptionRequest request) {
        return useCase.create(mapper.toDomain(request));
    }

}
