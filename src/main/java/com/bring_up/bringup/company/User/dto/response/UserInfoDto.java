package com.bring_up.bringup.company.User.dto.response;

import lombok.Builder;

@Builder
public record UserInfoDto(
        Long id,
        String email,
        String name
) {
}
