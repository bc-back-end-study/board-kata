package com.kata.borad.entity;

import lombok.Getter;

@Getter
public class Post {
    private long id;
    private String title;
    private String content;
    private int view;
    private long userId;

    public Post(long id, String title, String content, int view, long userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.view = view;
        this.userId = userId;
    }
}
