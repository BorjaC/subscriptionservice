package com.adidas.subscription.adapters.rest.request;

import lombok.Data;

@Data
public class EmailRequest {

    private Long id;
    private String email;
    private String name;
    private String gender;
    private String birthday;
    private Boolean consent;
    private Long newsletterId;

}
