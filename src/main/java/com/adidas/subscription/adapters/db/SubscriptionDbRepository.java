package com.adidas.subscription.adapters.db;

import com.adidas.subscription.adapters.db.dto.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SubscriptionDbRepository extends JpaRepository<SubscriptionEntity, Long> {

    @Modifying
    @Query(value = "UPDATE subscriptions SET consent = false WHERE id = :subscriptionId", nativeQuery = true)
    void cancel(Long subscriptionId);

}
