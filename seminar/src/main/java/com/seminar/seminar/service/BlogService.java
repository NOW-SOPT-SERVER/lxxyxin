package com.seminar.seminar.service;

import com.seminar.seminar.domain.Blog;
import com.seminar.seminar.domain.Member;
import com.seminar.seminar.exception.ErrorMessage;
import com.seminar.seminar.exception.NotFoundException;
import com.seminar.seminar.repository.BlogRepository;
import com.seminar.seminar.service.dto.BlogCreateRequest;
import com.seminar.seminar.service.dto.BlogTitleUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final MemberService memberService;

    public String create(Long memberId, BlogCreateRequest blogCreateRequest){
        //member 찾기
        Member member = memberService.findById(memberId);
        Blog blog = blogRepository.save(Blog.create(member,blogCreateRequest));
        return blog.getId().toString();
    }

    private Blog findById(Long blogId){
        return blogRepository.findById(blogId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND_BY_ID_EXCEPTION)
        );
    }

    @Transactional
    public void updateTitle(Long blogId, BlogTitleUpdateRequest blogTitleUpdateRequest){
        Blog blog = findById(blogId);
        blog.updateTitle(blogTitleUpdateRequest.title());
    }

    //멤버-블로그 검증
    public void validateMemberBlog(Long blogId, Long memberId){
        Blog blog = this.findById(blogId);
        if(!blog.getMember().getId().equals(memberId)){
            throw new NotFoundException(ErrorMessage.BLOG_NOT_FOUND_BY_MEMBER_ID_EXCEPTION);
        }
    }
}
