package com.seminar.seminar.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessMessage {
    BLOG_CREATED_SUCCESS(HttpStatus.CREATED.value(), "블로그 생성이 완료되었습니다.")
    ;
    private final int status;
    private final String message;

}
