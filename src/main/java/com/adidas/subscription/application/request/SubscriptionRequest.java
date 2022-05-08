package com.adidas.subscription.application.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "Subscription request", description = "Necessary data to create a subscription")
public class SubscriptionRequest {

    @NotBlank
    @Email(regexp = ".+[@].+[\\.].+", message = "Error 001")
    @ApiModelProperty(value = "Email of subscribed user", required = true)
    private String email;

    @ApiModelProperty(value = "First name of subscribed user")
    private String name;

    @Pattern(regexp = "^[(FE)MALE]*$", message = "Error 002")
    @ApiModelProperty(value = "Gender of subscribed user")
    private String gender;

    @NotNull
    @ApiModelProperty(value = "Date of birth of subscribed user", required = true)
    private String birthday;

    @NotNull
    @ApiModelProperty(value = "Indicate if the user is subscribed or not in this campaign", required = true)
    private Boolean consent;

    @NotNull
    @ApiModelProperty(value = "Id of the campaign", required = true)
    private Long newsletterId;

}
