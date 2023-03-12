package com.kata.borad.entity;

import lombok.Getter;

@Getter
public class Comment {
    private long id;
    private String reply;
    private long postId;
    private long userId;

    public Comment(long id, String reply, long postId, long userId) {
        this.id = id;
        this.reply = reply;
        this.postId = postId;
        this.userId = userId;
    }
}
