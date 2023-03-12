package com.kata.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("제목")
    private String title;

    @Column(columnDefinition = "TEXT")
    @Comment("내용")
    private String content;

    @Comment("조회 수")
    private Integer view = 0;

    @ManyToOne
    private User user;

    @Builder
    private Post(final String title, final String content, final Integer view, final User user) {
        this.title = title;
        this.content = content;
        this.view = viewCountValid(view);
        this.user = user;
    }

    private Integer viewCountValid(final Integer view) {
        if (view == null || view < 0) {
            throw new IllegalStateException("조회 수는 0보다 작을 수 없습니다.");
        }
        return view;
    }
}
