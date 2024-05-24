package com.bring_up.bringup.company.exception;

import com.bring_up.bringup.company.domain.enums.MemberErrorCode;
import lombok.Getter;

@Getter
public class MemberException extends RuntimeException {
    private final MemberErrorCode errorCode;

    public MemberException(MemberErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }
}