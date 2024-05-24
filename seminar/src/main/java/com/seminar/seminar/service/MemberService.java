package com.seminar.seminar.service;

import com.seminar.seminar.auth.UserAuthentication;
import com.seminar.seminar.common.jwt.JwtTokenProvider;
import com.seminar.seminar.domain.Member;
import com.seminar.seminar.exception.ErrorMessage;
import com.seminar.seminar.exception.NotFoundException;
import com.seminar.seminar.repository.MemberRepository;
import com.seminar.seminar.service.dto.MemberCreateDto;
import com.seminar.seminar.service.dto.MemberFindDto;
import com.seminar.seminar.service.dto.UserJoinResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

//    @Transactional //영속성 context
//    //final 붙이는 경우도 가능
//    public String createMember(final MemberCreateDto memberCreate){
//        Member member = memberRepository.save(Member.create(memberCreate.name(), memberCreate.part(), memberCreate.age()));
//        return member.getId().toString();
//    }

    @Transactional
    public UserJoinResponse createMember(MemberCreateDto memberCreateDto){
        Member member = memberRepository.save(
                Member.create(memberCreateDto.name(), memberCreateDto.part(), memberCreateDto.age())
        );
        Long memberId = member.getId();
        String accessToken = jwtTokenProvider.issueAccessToken(
                UserAuthentication.createUserAuthentication(memberId)
        );
        return UserJoinResponse.of(accessToken, memberId.toString());
    }

    public MemberFindDto findMemberById(Long memberId){
        return MemberFindDto.of(memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("ID에 해당하는 사용자가 없습니다.")
        ));
    }
    public Member findById(Long memberId){
        return memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("사용자 없음")
        );
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
                ()-> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION));
        memberRepository.delete(member);
    }
}
