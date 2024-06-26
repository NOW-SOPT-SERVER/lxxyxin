package com.sopt.second.service;

import com.sopt.second.domain.Member;
import com.sopt.second.repository.MemberRepository;
import com.sopt.second.service.dto.MemberCreateDto;
import com.sopt.second.service.dto.MemberFindDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional //영속성 context
    //final 붙이는 경우도 가능
    public String createMember(final MemberCreateDto memberCreate){
        Member member = memberRepository.save(Member.create(memberCreate.name(), memberCreate.part(), memberCreate.age()));
        return member.getId().toString();
    }

    public MemberFindDto findMemberById(Long memberId){
        return MemberFindDto.of(memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("ID에 해당하는 사용자가 없습니다.")
        ));
    }

    public List<MemberFindDto> findMembers(){
        List<MemberFindDto> memberList;
        memberList = memberRepository.findAll().stream()
                .map(member -> new MemberFindDto(member.getName(), member.getPart(), member.getAge()))
                .toList();
        return memberList;
    }

    @Transactional //DB에 변경사항이 생겼을 때 사용
    public void deleteMemberById(Long memberId){
        //해당 Id를 가진 member 찾기
        Member member = memberRepository.findById(memberId).orElseThrow(
                ()-> new EntityNotFoundException("ID에 해당하는 사람이 없습니다"));
        memberRepository.delete(member);
    }
}
