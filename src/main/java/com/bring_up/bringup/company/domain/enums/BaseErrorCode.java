package com.bring_up.bringup.company.domain.enums;

import com.bring_up.bringup.company.domain.response.ErrorResponse;
import org.springframework.http.HttpStatus;

public interface BaseErrorCode {
    int getErrorCode();

    String getErrorMessage();

    HttpStatus getStatus();

    ErrorResponse getErrorResponse();
}