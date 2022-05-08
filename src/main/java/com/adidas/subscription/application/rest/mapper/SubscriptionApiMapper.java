package com.adidas.subscription.application.rest.mapper;

import com.adidas.subscription.application.request.SubscriptionRequest;
import com.adidas.subscription.application.response.SubscriptionResponse;
import com.adidas.subscription.domain.Subscription;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubscriptionApiMapper {

    Subscription toDomain(SubscriptionRequest request);

    SubscriptionResponse toResponse(Subscription source);

    List<SubscriptionResponse> toResponse(List<Subscription> source);

}
