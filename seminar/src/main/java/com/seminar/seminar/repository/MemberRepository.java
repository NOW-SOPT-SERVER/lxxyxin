package com.seminar.seminar.repository;

import com.seminar.seminar.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
