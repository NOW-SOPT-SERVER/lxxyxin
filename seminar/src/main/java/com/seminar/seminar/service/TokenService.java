package com.seminar.seminar.service;

import com.seminar.seminar.auth.UserAuthentication;
import com.seminar.seminar.common.jwt.JwtTokenProvider;
import com.seminar.seminar.common.jwt.JwtValidationType;
import com.seminar.seminar.domain.Token;
import com.seminar.seminar.exception.ErrorMessage;
import com.seminar.seminar.exception.NotFoundException;
import com.seminar.seminar.exception.UnauthorizedException;
import com.seminar.seminar.repository.RedisTokenRepository;
import com.seminar.seminar.service.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class TokenService {
    private final RedisTokenRepository redisTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenDto newAccessToken(String refreshToken){
        Token token = redisTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(
                        () -> new NotFoundException(ErrorMessage.REFRESH_TOKEN_NOT_FOUND_EXCEPTION)
                );
        if (jwtTokenProvider.validateToken(token.getRefreshToken()) == JwtValidationType.EXPIRED_JWT_TOKEN)
            throw new UnauthorizedException(ErrorMessage.JWT_UNAUTHORIZED_EXCEPTION);

        String newToken = jwtTokenProvider.newAccessToken(token.getRefreshToken());
        return TokenDto.of(newToken);
    }

}
