package com.seminar.seminar.service.dto;

import org.springframework.web.multipart.MultipartFile;

public record BlogCreateRequest(
        String title,
        String description,
        MultipartFile image
) {
}

