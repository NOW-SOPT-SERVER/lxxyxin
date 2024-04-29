package com.seminar.seminar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seminar.seminar.repository.BlogRepository;
import com.seminar.seminar.repository.MemberRepository;
import com.seminar.seminar.service.BlogService;
import com.seminar.seminar.service.MemberService;
import com.seminar.seminar.service.dto.BlogCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BlogControllerTest.class) //컨트롤러 계층만 테스트
@AutoConfigureMockMvc //스프링 부트 테스트에서 MockMvc를 사용하기 위한 설정 제공 어노테이션
public class BlogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SpyBean
    private BlogService blogService;

    @SpyBean
    private MemberService memberService;

    @MockBean
    private MemberRepository memberRepository;

    @MockBean
    private BlogRepository blogRepository;

    @Autowired
    private ObjectMapper objectMapper; //생성하는 객체를 String JSON 배열로 바꾸기 위해 사용

    @Nested
    class createBlog{
        @Test
        @DisplayName("Blog 생성 실패 테스트")
        public void createBlogFail() throws Exception{
            //given
            String request = objectMapper.writeValueAsString(new BlogCreateRequest("예린이 블로그", "애옹"));

            //when
            mockMvc.perform(
                        post("/api/v1/blog")
                                .content(request).header("memberId", 2)
                                .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound())
                    .andDo(print());

        }
    }





}
