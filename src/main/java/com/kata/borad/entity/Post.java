package com.kata.borad.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private long userId;

}
