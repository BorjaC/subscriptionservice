package com.adidas.subscription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Subscription application. Manage the data about all campaign. I suppose a email can be subscribed for
 * different campaigns (newsletters). A campaign is cancelled when a user denies a consent.
 *
 *
 */
@SpringBootApplication
@EnableConfigurationProperties
public class SubscriptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionApplication.class, args);
	}

}
