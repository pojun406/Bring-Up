package com.bring_up.bringup.company.dto;

import lombok.Builder;

@Builder
public record ValidationRequestDto(
        String businessNumber, // 사업자번호

        String startDate, // 개업일자

        String name // 대표자 성명
) {
    @Override
    public String businessNumber() {
        return businessNumber;
    }

    @Override
    public String startDate() {
        return startDate;
    }

    @Override
    public String name() {
        return name;
    }
}
