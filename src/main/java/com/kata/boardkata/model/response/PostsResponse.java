package com.kata.boardkata.model.response;

import com.kata.boardkata.model.dto.PostDto;
import com.kata.boardkata.repository.PostRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class PostsResponse {
    private List<PostDto> postDtoList;
    private int size;

    public static PostsResponse makePostResponse(List<PostDto> posts){
        PostsResponse postsResponse = new PostsResponse();
        postsResponse.setPostDtoList(posts);
        postsResponse.setSize(posts.size());
        return postsResponse;
    }
}
