package com.seminar.seminar.controller;

import com.seminar.seminar.common.dto.SuccessMessage;
import com.seminar.seminar.common.dto.SuccessStatusResponse;
import com.seminar.seminar.service.PostService;
import com.seminar.seminar.service.dto.PostCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blog")
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<SuccessStatusResponse> createPost(
            @RequestHeader(name = "blogId") Long blogId,
            @RequestBody PostCreateDto postCreateDto
    ){
        return ResponseEntity.status(HttpStatus.CREATED).header(
                "Location",
                postService.create(blogId, postCreateDto)
        ).body(SuccessStatusResponse.of(SuccessMessage.POST_CREATED_SUCCESS));
    }

}
