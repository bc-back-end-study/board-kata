package com.kata.boardkata.model.response;

import com.kata.boardkata.entity.Post;

import java.time.LocalDateTime;

public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private int view;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public static PostResponse makeToPostResponse(Post post) {
        PostResponse postResponse = new PostResponse();
        postResponse.id = post.getId();
        postResponse.title = post.getTitle();
        postResponse.content = post.getContent();
        postResponse.view = post.getView();
        postResponse.createdDate = post.getCreatedDate();
        postResponse.modifiedDate = post.getModifiedDate();
        return postResponse;
    }
}
