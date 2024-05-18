package com.seminar.seminar.repository;

import com.seminar.seminar.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Blog findByMemberId(Long memberId);
}
