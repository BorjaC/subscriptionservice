package com.adidas.subscription.domain.exception;

import lombok.Getter;

public enum ApiError {

    ERROR_000("Invalid token security"),
    ERROR_001("The current user is subscribed in this campaign"),
    ERROR_002("Subscription $1 is not found"),
    ERROR_003("Impossible send email, the subscription process can not finish");


    @Getter
    private String message;


    private ApiError(String message) {
        this.message = message;
    }

}
