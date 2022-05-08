package com.adidas.subscription.domain.repository;

import com.adidas.subscription.domain.Subscription;

import java.util.List;

public interface SubscriptionRepository {

    Subscription save(Subscription subscription);

    void cancel(Long subscriptionId);

    Subscription findById(Long subscriptionId);

    List<Subscription> findAll();

}
