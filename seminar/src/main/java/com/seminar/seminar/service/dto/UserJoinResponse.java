package com.seminar.seminar.service.dto;

public record UserJoinResponse(
        String accessToken,
        String refreshToken,
        String userId
) {

    public static UserJoinResponse of(
            String accessToken,
            String refreshToken,
            String memberId
    ) {
        return new UserJoinResponse(accessToken, refreshToken, memberId
                );
    }
}


