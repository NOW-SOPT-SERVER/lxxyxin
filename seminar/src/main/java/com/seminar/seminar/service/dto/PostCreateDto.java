package com.seminar.seminar.service.dto;

import jakarta.validation.constraints.Size;

public record PostCreateDto(
        @Size(max = 20, message = "게시글 제목의 최대 글자 수(20자)를 초과했습니다.") String title,
        @Size(max = 4000, message = "게시글 내용의 최대 글자 수(4000자)를 초과했습니다.") String content) {
}
