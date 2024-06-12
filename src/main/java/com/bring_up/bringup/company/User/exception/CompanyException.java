package com.bring_up.bringup.company.User.exception;

import com.bring_up.bringup.company.common.enums.MemberErrorCode;
import lombok.Getter;

@Getter
public class CompanyException extends RuntimeException {
    private final MemberErrorCode errorCode;

    public CompanyException(MemberErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }
}