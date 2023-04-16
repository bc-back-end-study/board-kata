package com.kata.boardkata.model.dto;

import com.kata.boardkata.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private Long id;
    private String title;
    private String userName;
    private int view;
    private LocalDateTime createdDate;
    public static PostDto PostToPostDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setView(post.getView());
        postDto.setTitle(post.getTitle());
        postDto.setCreatedDate(post.getCreatedDate());
        postDto.setId(post.getId());
        postDto.setUserName(post.getUser().getUsername());
        return postDto;
    }
}
