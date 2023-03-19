package com.kata.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity // Entity로 선언된 클래스의 이름은 실제 DB 테이블명과 일치하는 것을 매핑한다
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id // primary key 가지는 변수 선언
    @GeneratedValue(strategy= GenerationType.AUTO) // ID값 자동 생성 auto
    private Long id;
    private String title;
    private String content;
    private int view;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private long userId;

}
