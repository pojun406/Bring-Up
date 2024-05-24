package com.bring_up.bringup.company.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ValidationRequestInfo{
    private String b_no;
    private String start_dt;
    private String p_nm;

    @Builder
    public ValidationRequestInfo(String b_no, String start_dt, String p_nm) {
        this.b_no = b_no;
        this.start_dt = start_dt;
        this.p_nm = p_nm;
    }

    public static ValidationRequestInfo from(ValidationRequestDto dto) {
        return ValidationRequestInfo.builder()
                .b_no(dto.businessNumber())
                .start_dt(dto.startDate())
                .p_nm(dto.name())
                .build();
    }
}