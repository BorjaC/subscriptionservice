package com.adidas.subscription.infrastructure.configuration;

import com.adidas.subscription.domain.exception.AuthorizationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class SecurityInterceptor implements HandlerInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String key = "password";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (handler instanceof ResourceHttpRequestHandler
                || "org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController#error(HttpServletRequest)".equals(handler.toString())) {
            return true;
        }

        String authorization = request.getHeader(AUTHORIZATION_HEADER);

        if (!key.equals(authorization)) {
            throw new AuthorizationException();
        }

        return true;
    }

}


