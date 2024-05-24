package com.seminar.seminar.controller;

import com.seminar.seminar.auth.PrincipalHandler;
import com.seminar.seminar.common.dto.SuccessMessage;
import com.seminar.seminar.common.dto.SuccessStatusResponse;
import com.seminar.seminar.service.BlogService;
import com.seminar.seminar.service.dto.BlogCreateRequest;
import com.seminar.seminar.service.dto.BlogTitleUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1") //매핑을 너무 디테일하게 해버리면 현업에서 수정할 때 찾기 어려워질 수 있다는 의견이 있다...
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;
    private final PrincipalHandler principalHandler;
//    @PostMapping("/blog")
//    public ResponseEntity<SuccessStatusResponse> createBlog(
//            @RequestHeader(name = "memberId") Long memberId, //보안 상 중요한 정보,
//            @RequestBody BlogCreateRequest blogCreateRequest){
//            return ResponseEntity.status(HttpStatus.CREATED).header(
//                    "Location",
//                    blogService.create(memberId, blogCreateRequest))
//                    .body(SuccessStatusResponse.of(SuccessMessage.BLOG_CREATED_SUCCESS));
//    }

//    @PostMapping("/blog")
//    public ResponseEntity createBlog(
//            BlogCreateRequest blogCreateRequest
//    ){
//        return ResponseEntity.created(URI.create(blogService.create(
//                principalHandler.getUserIdFromPrincipal(), blogCreateRequest
//        ))).build();
//    }

    @PostMapping("/blog")
    public ResponseEntity createBlog(
            @ModelAttribute BlogCreateRequest blogCreateRequest
    ) {
        return ResponseEntity.created(URI.create(blogService.create(
                principalHandler.getUserIdFromPrincipal(), blogCreateRequest))).build();
    }
    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogTitleUpdateRequest blogTitleUpdateRequest
    ) {
        blogService.updateTitle(blogId, blogTitleUpdateRequest);
        return ResponseEntity.noContent().build();
    }

}
