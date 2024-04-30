package com.seminar.seminar.service;

import com.seminar.seminar.domain.Blog;
import com.seminar.seminar.domain.Post;
import com.seminar.seminar.exception.ErrorMessage;
import com.seminar.seminar.exception.NotFoundException;
import com.seminar.seminar.repository.BlogRepository;
import com.seminar.seminar.repository.PostRepository;
import com.seminar.seminar.service.dto.PostCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final BlogRepository blogRepository;

    public String create(Long blogId, PostCreateDto postCreateDto) {
        //Blog가 존재하는지 검사
        Blog blog = blogRepository.findById(blogId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND_BY_ID_EXCEPTION)
        );
        Post post = postRepository.save(Post.create(blog, postCreateDto));
        return post.getId().toString();
    }
}
