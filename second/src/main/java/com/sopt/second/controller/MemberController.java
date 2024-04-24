package com.sopt.second.controller;


import com.sopt.second.service.MemberService;
import com.sopt.second.service.dto.MemberCreateDto;
import com.sopt.second.service.dto.MemberFindDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
//초기화 되지 않은 final 필드나 @NonNull이 붙은 필드에 대해 생성자를 만들어주는 어노테이션
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity createMember(@RequestBody MemberCreateDto memberCreate){
        return ResponseEntity.created(URI.create(memberService.createMember(memberCreate))).build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindDto> findtMemberById(@PathVariable Long memberId){
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    @GetMapping("/memberList")
    public ResponseEntity<List<MemberFindDto>> findMemberList(){
        return ResponseEntity.ok(memberService.findMembers());
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMember(@PathVariable Long memberId){
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }
}