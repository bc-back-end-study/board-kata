package com.kata.boardkata.entity;

import com.kata.boardkata.model.Vo.PostVo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private int view;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Post (PostVo postVo, User user) {
        this.id = postVo.getId();
        this.title = postVo.getTitle();
        this.content = postVo.getContent();
        this.view = postVo.getView();
        this.createdDate = postVo.getCreatedDate();
        this.modifiedDate = postVo.getModifiedDate();
        this.user = user;
    }
}
