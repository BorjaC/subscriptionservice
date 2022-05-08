package com.adidas.subscription.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Subscription {

    private long id;
    private String email;
    private String name;
    private String gender;
    private String birthday;
    private boolean consent;
    private String newsletterId;

}
