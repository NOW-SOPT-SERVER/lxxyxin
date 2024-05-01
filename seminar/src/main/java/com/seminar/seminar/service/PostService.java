package com.seminar.seminar.service;

import com.seminar.seminar.domain.Blog;
import com.seminar.seminar.domain.Post;
import com.seminar.seminar.exception.ErrorMessage;
import com.seminar.seminar.exception.NotFoundException;
import com.seminar.seminar.repository.BlogRepository;
import com.seminar.seminar.repository.MemberRepository;
import com.seminar.seminar.repository.PostRepository;
import com.seminar.seminar.service.dto.PostCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final BlogRepository blogRepository;
    private final BlogService blogService;
    public String create(Long blogId, Long memberId, PostCreateDto postCreateDto) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.POST_NOT_FOUND_BY_BLOG_ID_EXCEPTION)
        );
        blogService.validateMemberBlog(blogId, memberId);
        Post post = postRepository.save(Post.create(blog, postCreateDto));
        return post.getId().toString();
    }

    //블로그 전체 글 조회
    public List<Post> findAllPostsByBlogId(Long blogId){
        List<Post> posts = postRepository.findByBlogId(blogId);
        if(posts.isEmpty()){
            throw new NotFoundException(ErrorMessage.POST_NOT_FOUND_BY_BLOG_ID_EXCEPTION);
        }
        return posts;
    }

    //블로그 개별 글 조회
    public Post findById(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.POST_NOT_FOUND_BY_ID_EXCEPTION)
        );
        return post;
    }
}
