package com.sopt.second.service.dto;

import com.sopt.second.domain.Member;
import com.sopt.second.domain.Part;

public record MemberFindDto(String name, Part part, int age) {
    public static MemberFindDto of(Member member){
        return new MemberFindDto(member.getName(), member.getPart(), member.getAge());
    }
}