package com.kata.borad.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    private long id;
    private String title;
    private String content;
    private int view;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private long userId;

}
