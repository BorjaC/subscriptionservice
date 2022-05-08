package com.adidas.subscription.domain.usecase;

import com.adidas.subscription.domain.Subscription;
import com.adidas.subscription.domain.exception.ApiError;
import com.adidas.subscription.domain.exception.SubscriptionException;
import com.adidas.subscription.domain.repository.EmailRepository;
import com.adidas.subscription.domain.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Create new subscription use case. Save new subscription in database and send a email.
 * If the email fail, the subscription is saved in database. It needs a rollback system
 * to avoid fake subscriptions in database
 *
 */
@Service
@RequiredArgsConstructor
public class CreateSubscriptionUseCase {

    private final SubscriptionRepository subscriptionRepository;
    private final EmailRepository emailRepository;

    /**
     * Create new subscription
     *
     * @param subscription subscription data.
     * @return subscription id.
     */
    public Long create(Subscription subscription) {

        subscription = saveSubscription(subscription);
        sendEmail(subscription);

        return subscription.getId();
    }

    /**
     * Save new subscription in database.
     *
     * @param subscription subscription.
     * @return created subscription.
     */
    private Subscription saveSubscription(Subscription subscription) {
        try {

            subscription = subscriptionRepository.save(subscription);

        } catch (Exception exception) {
            throw new SubscriptionException(ApiError.ERROR_001);
        }
        return subscription;
    }

    /**
     * Send email to inform the user that it is subscribed a news letters campaign.
     *
     * @param subscription subscription data.
     */
    private void sendEmail(Subscription subscription) {
        try {
            emailRepository.sendEmail(subscription);
        } catch (Exception exception) {
            // TODO Implement rollback system if it is fail.
            throw new SubscriptionException(ApiError.ERROR_003);
        }
    }

}
