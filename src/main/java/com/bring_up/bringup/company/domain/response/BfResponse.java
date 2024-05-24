package com.bring_up.bringup.company.domain.response;

import com.bring_up.bringup.company.domain.enums.GlobalSuccessCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.Map;

import static com.bring_up.bringup.company.domain.enums.GlobalSuccessCode.SUCCESS;

@Getter
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class BfResponse<T> {
    private int code;

    private String message;

    private T data;

    public BfResponse(T data) {
        this.code = SUCCESS.getCode();
        this.message = SUCCESS.getMessage();
        this.data = data;
    }

    public BfResponse(GlobalSuccessCode statusCode, T data) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.data = data;
    }

    public BfResponse(GlobalSuccessCode statusCode) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
    }
}
