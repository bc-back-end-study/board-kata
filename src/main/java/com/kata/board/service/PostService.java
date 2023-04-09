package com.kata.board.service;

import com.kata.board.entity.Post;
import com.kata.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> selectAll(){
        List<Post> postList = postRepository.findAll();
        return postList;
    }
}
