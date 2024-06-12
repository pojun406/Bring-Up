package com.bring_up.bringup.company.User.dto.response;

import lombok.Builder;

@Builder
public record LoginTokenDto(
        String accessToken,
        String refreshToken
) {
}
