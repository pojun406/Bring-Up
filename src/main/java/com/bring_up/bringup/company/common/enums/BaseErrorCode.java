package com.bring_up.bringup.company.common.enums;


import com.illiterate.illiterate.common.response.ErrorResponse;
import org.springframework.http.HttpStatus;

public interface BaseErrorCode {
	int getErrorCode();

	String getErrorMessage();

	HttpStatus getStatus();

	ErrorResponse getErrorResponse();
}
