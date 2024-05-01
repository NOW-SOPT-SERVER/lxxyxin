package com.seminar.seminar.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessMessage {
    BLOG_CREATED_SUCCESS(HttpStatus.CREATED.value(), "블로그 생성이 완료되었습니다."),
    POST_CREATED_SUCCESS(HttpStatus.CREATED.value(), "게시글이 작성되었습니다."),
    POST_ALL_FIND_SUCCESS(HttpStatus.OK.value(), "모든 게시글이 조회되었습니다."),
    POST_FIND_SUCCESS(HttpStatus.OK.value(), "게시글을 조회했습니다.")
    ;
    private final int status;
    private final String message;

}
