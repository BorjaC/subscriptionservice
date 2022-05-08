package com.adidas.subscription.domain.repository;

import com.adidas.subscription.domain.Subscription;

public interface EmailRepository {

    void sendEmail(Subscription subscription);

}
