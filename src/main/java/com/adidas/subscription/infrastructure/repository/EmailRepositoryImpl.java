package com.adidas.subscription.infrastructure.repository;

import com.adidas.subscription.adapters.rest.EmailClient;
import com.adidas.subscription.domain.Subscription;
import com.adidas.subscription.domain.repository.EmailRepository;
import com.adidas.subscription.infrastructure.configuration.SecurityInterceptor;
import com.adidas.subscription.infrastructure.repository.mapper.EmailApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailRepositoryImpl implements EmailRepository {

    private final EmailClient client;
    private final EmailApiMapper mapper;

    @Override
    public void sendEmail(Subscription subscription) {
        client.sendEmail(SecurityInterceptor.key, mapper.toRequest(subscription));
    }

}
