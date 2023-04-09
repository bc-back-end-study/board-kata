package com.kata.boardkata.model.Vo;

import com.kata.boardkata.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter //테스트코드를 위한 어노테이션
@AllArgsConstructor //테스트코드를 위한 어노테이션
public class PostVo {
    private Long id;
    private String title;
    private String content;
    private int view;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String userId;
}
