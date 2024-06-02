package com.seminar.seminar.controller;

import com.seminar.seminar.service.TokenService;
import com.seminar.seminar.service.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/api/v1/auth")
public class TokenController {
    private final TokenService tokenService;
    @PostMapping("/refreshToken")
    public ResponseEntity<TokenDto> createNewAccessToken(
            @RequestHeader String refreshToken
    ){
        TokenDto tokenDto = tokenService.newAccessToken(refreshToken);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(tokenDto);
    }
}
