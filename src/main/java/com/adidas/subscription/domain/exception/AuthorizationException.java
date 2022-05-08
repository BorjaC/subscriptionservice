package com.adidas.subscription.domain.exception;

import lombok.Getter;

public class AuthorizationException extends RuntimeException {

    @Getter
    private ApiError apiError = ApiError.ERROR_000;

    public AuthorizationException() {
        super(ApiError.ERROR_000.getMessage());
    }


}
