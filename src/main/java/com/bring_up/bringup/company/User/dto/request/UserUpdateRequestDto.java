package com.bring_up.bringup.company.User.dto.request;

public record UserUpdateRequestDto(
        String name,                            // 닉네임

        String email
) {
}
