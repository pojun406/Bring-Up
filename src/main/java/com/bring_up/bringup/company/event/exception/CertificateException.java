package com.bring_up.bringup.company.event.exception;


import com.illiterate.illiterate.common.enums.CertificateErrorCode;
import lombok.Getter;

@Getter
public class CertificateException extends RuntimeException{

    private final CertificateErrorCode errorCode;

    public CertificateException(CertificateErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }
}
