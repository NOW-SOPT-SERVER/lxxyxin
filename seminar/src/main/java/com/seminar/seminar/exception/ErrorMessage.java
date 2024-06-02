package com.seminar.seminar.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    MEMBER_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
    BLOG_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 블로그가 존재하지 않습니다."),
    BLOG_NOT_FOUND_BY_MEMBER_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "해당 사용자의 블로그가 존재하지 않습니다."),
    POST_NOT_FOUND_BY_BLOG_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(),"해당 블로그에 게시물이 존재하지 않습니다."),
    POST_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 게시글이 존재하지 않습니다."),
    JWT_UNAUTHORIZED_EXCEPTION(HttpStatus.UNAUTHORIZED.value(), "사용자의 로그인 검증을 실패했습니다."),
    REFRESH_TOKEN_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND.value(), "해당 Refresh token이 존재하지 않습니다."),
    JWT_EXPIRED_EXCEPTION(HttpStatus.UNAUTHORIZED.value(), "만료된 토큰입니다.")
    ;
    private final int status;
    private final String message;
}
