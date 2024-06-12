package com.bring_up.bringup.company.event.dto.response;

import lombok.Builder;

@Builder
public record CertificateMailResponseDto(
        int mailExpirationSeconds,

        String certificationNumber
) {
}
