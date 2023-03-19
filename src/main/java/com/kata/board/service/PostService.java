package com.kata.board.service;

import com.kata.board.dto.PostDto;
import com.kata.board.entity.Post;
import com.kata.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostDto> getPostList(){
        return postRepository.findAllBy().stream().map(Post::makeToPostDto)
                .collect(Collectors.toList());
    }

}
