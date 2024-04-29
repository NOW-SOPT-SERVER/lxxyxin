package com.seminar.seminar.service.dto;

import com.seminar.seminar.domain.Part;

public record MemberCreateDto(String name, Part part, int age) {
}
