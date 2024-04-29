package com.seminar.seminar.controller;

import com.seminar.seminar.service.MemberService;
import com.seminar.seminar.service.dto.MemberCreateDto;
import com.seminar.seminar.service.dto.MemberFindDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
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
