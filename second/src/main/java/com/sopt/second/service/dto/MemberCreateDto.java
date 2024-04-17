package com.sopt.second.service.dto;

import com.sopt.second.domain.Part;

public record MemberCreateDto(String name, Part part, int age) {
}
