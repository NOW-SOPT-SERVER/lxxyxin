package com.seminar.seminar.domain;

import com.seminar.seminar.service.dto.BlogCreateRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Blog extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    @Column(length = 200)
    private String title;

    private String description;

    private String imageUrl;

    private Blog(Member member, String title, String imageUrl ,String description){
        this.member = member;
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
    }
//    public static Blog create(Member member, BlogCreateRequest blogCreateRequest){
//        return new Blog(member, blogCreateRequest.title(), blogCreateRequest.description());
//    }
    public static Blog create(
        Member member,
        String title,
        String description,
        String imageUrl
    ) {
        return new Blog(member, title, imageUrl, description);
    }

    public void updateTitle(String title){
        this.title = title;
    }

}
