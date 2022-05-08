package com.adidas.subscription.domain.usecase;

import com.adidas.subscription.domain.Subscription;
import com.adidas.subscription.domain.exception.SubscriptionException;
import com.adidas.subscription.domain.repository.EmailRepository;
import com.adidas.subscription.domain.repository.SubscriptionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateSubscriptionUseCaseTest {

    @Mock
    private SubscriptionRepository subscriptionRepository;
    @Mock
    private EmailRepository emailRepository;
    @InjectMocks
    private CreateSubscriptionUseCase useCase;


    @Test
    public void create_ok() {

        Subscription subscription = new Subscription();
        subscription.setId(1);

        when(subscriptionRepository.save(subscription)).thenReturn(subscription);
        doNothing().when(emailRepository).sendEmail(any());

        Long id = useCase.create(subscription);

        assertEquals(1, id);
        verify(subscriptionRepository).save(subscription);
        verify(emailRepository).sendEmail(subscription);

    }

    @Test(expected = SubscriptionException.class)
    public void create_api_error_001() {

        Subscription subscription = new Subscription();
        subscription.setId(1);

        when(subscriptionRepository.save(subscription)).thenThrow(new RuntimeException());

        useCase.create(subscription);

        verify(subscriptionRepository).save(subscription);
        verify(emailRepository, times(0)).sendEmail(subscription);

    }

    @Test(expected = SubscriptionException.class)
    public void create_api_error_003() {

        Subscription subscription = new Subscription();
        subscription.setId(1);

        when(subscriptionRepository.save(subscription)).thenReturn(subscription);
        doThrow(new RuntimeException()).when(emailRepository).sendEmail(any());

        useCase.create(subscription);

        verify(subscriptionRepository).save(subscription);
        verify(emailRepository).sendEmail(subscription);

    }

}
