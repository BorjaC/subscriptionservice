package com.adidas.subscription.domain.exception;

import lombok.Getter;

public class SubscriptionException extends RuntimeException {

    @Getter
    private ApiError apiError;

    public SubscriptionException(ApiError error) {
        super(error.getMessage());
        this.apiError = error;
    }

    public SubscriptionException(ApiError error, String arg) {
        super(error.getMessage().replace("$1", arg));
        this.apiError = error;
    }

}
