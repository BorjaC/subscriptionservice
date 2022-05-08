package com.adidas.subscription.adapters.rest;

import com.adidas.subscription.adapters.rest.request.EmailRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "EmailClient", url = "${adidas.service.email.url}", path = "/email")
public interface EmailClient {

    @RequestMapping(method = RequestMethod.POST)
    void sendEmail(@RequestHeader("Authorization") String authorization, @RequestBody EmailRequest request);

}
