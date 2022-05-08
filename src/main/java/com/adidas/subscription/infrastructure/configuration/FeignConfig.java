package com.adidas.subscription.infrastructure.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.adidas.subscription.adapters.rest")
public class FeignConfig {
}
