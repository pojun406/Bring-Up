package com.bring_up.bringup.company.dto;

import java.util.List;

public record ValidationResponseDto(
        int requestCnt,
        String statusCode,
        List<ValidationResult> data
) {
    public record ValidationResult(
            String bNo,
            String valid,
            String validMsg
    ) {
    }
}