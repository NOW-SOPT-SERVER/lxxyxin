package com.seminar.seminar.controller;

import com.seminar.seminar.common.dto.SuccessMessage;
import com.seminar.seminar.common.dto.SuccessStatusResponse;
import com.seminar.seminar.domain.Post;
import com.seminar.seminar.exception.ErrorMessage;
import com.seminar.seminar.exception.NotFoundException;
import com.seminar.seminar.service.PostService;
import com.seminar.seminar.service.dto.PostCreateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blog")
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<SuccessStatusResponse> createPost(
            @RequestHeader(name = "blogId") Long blogId,
            @RequestHeader(name = "memberId") Long memberId,
            @Valid @RequestBody PostCreateDto postCreateDto
    ){
        return ResponseEntity.status(HttpStatus.CREATED).header(
                "Location",
                postService.create(blogId, memberId, postCreateDto)
        ).body(SuccessStatusResponse.of(SuccessMessage.POST_CREATED_SUCCESS));
    }


    @GetMapping("/post")
    public ResponseEntity<SuccessStatusResponse> findAllPosts(
            @RequestHeader(name = "blogId") Long blogId
    ) {
        List<Post> posts = postService.findAllPostsByBlogId(blogId);
        return ResponseEntity.ok(SuccessStatusResponse.of(SuccessMessage.POST_ALL_FIND_SUCCESS));
    }


    @GetMapping("/post/{postId}")
    public ResponseEntity<SuccessStatusResponse> findPost(
            @RequestHeader(name = "blogId") Long blogId,
            @PathVariable Long postId
    ){
        Post post = postService.findById(postId);
        return ResponseEntity.ok(SuccessStatusResponse.of(SuccessMessage.POST_FIND_SUCCESS));
    }

}
