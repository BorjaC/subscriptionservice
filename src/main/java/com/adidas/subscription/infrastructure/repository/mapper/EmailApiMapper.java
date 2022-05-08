package com.adidas.subscription.infrastructure.repository.mapper;

import com.adidas.subscription.adapters.rest.request.EmailRequest;
import com.adidas.subscription.domain.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailApiMapper {

    EmailRequest toRequest(Subscription source);

}
