package com.adidas.subscription.application.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Subscription response", description = "Details of subscription")
public class SubscriptionResponse {

    @ApiModelProperty("Subscription id")
    private Long id;

    @ApiModelProperty("Email of subscribed user")
    private String email;

    @ApiModelProperty("First name of subscribed user")
    private String name;

    @ApiModelProperty("Gender of subscribed user")
    private String gender;

    @ApiModelProperty("Date of birth of subscribed user")
    private String birthday;

    @ApiModelProperty("Indicate if the user is subscribed or not in this campaign")
    private boolean consent;

    @ApiModelProperty("Id of the campaign")
    private long newsletterId;

}
