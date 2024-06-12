package com.bring_up.bringup.company.common.enums;

import com.bring_up.bringup.company.common.response.ErrorResponse;
import org.springframework.http.HttpStatus;

public interface BaseErrorCode {
    int getErrorCode();

    String getErrorMessage();

    HttpStatus getStatus();

    ErrorResponse getErrorResponse();
}