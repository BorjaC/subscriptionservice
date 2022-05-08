package com.adidas.subscription.infrastructure.repository;

import com.adidas.subscription.adapters.db.SubscriptionDbRepository;
import com.adidas.subscription.domain.Subscription;
import com.adidas.subscription.domain.exception.ApiError;
import com.adidas.subscription.domain.exception.SubscriptionException;
import com.adidas.subscription.domain.repository.SubscriptionRepository;
import com.adidas.subscription.infrastructure.repository.mapper.SubscriptionDbMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionRepositoryImpl implements SubscriptionRepository {


    private final SubscriptionDbRepository dbRepository;
    private final SubscriptionDbMapper mapper;


    @Override
    @Transactional
    public Subscription save(Subscription subscription) {
        return mapper.toDomain(dbRepository.save(mapper.toEntity(subscription)));
    }

    @Override
    @Transactional
    public void cancel(Long subscriptionId) {
        dbRepository.cancel(subscriptionId);
    }

    @Override
    @Transactional
    public Subscription findById(Long subscriptionId) {
        log.info("id {}", subscriptionId);
        return mapper.toDomain(dbRepository.findById(subscriptionId)
                .orElseThrow(() -> new SubscriptionException(ApiError.ERROR_002, String.valueOf(subscriptionId))));
    }

    @Override
    @Transactional
    public List<Subscription> findAll() {
        return mapper.toDomain(dbRepository.findAll());
    }
}
