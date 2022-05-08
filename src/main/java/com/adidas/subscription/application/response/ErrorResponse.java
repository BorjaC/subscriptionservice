package com.adidas.subscription.application.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "Error response", description = "Error details")
public class ErrorResponse {

    @ApiModelProperty("Code error")
    private String code;

    @ApiModelProperty("Message error")
    private String message;

}
