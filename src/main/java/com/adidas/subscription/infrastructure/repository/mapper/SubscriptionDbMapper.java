package com.adidas.subscription.infrastructure.repository.mapper;

import com.adidas.subscription.adapters.db.dto.SubscriptionEntity;
import com.adidas.subscription.domain.Subscription;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubscriptionDbMapper {

    SubscriptionEntity toEntity(Subscription source);

    Subscription toDomain(SubscriptionEntity entity);

    List<Subscription> toDomain(List<SubscriptionEntity> entity);

}
