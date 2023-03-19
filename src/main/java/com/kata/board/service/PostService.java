package com.kata.board.service;

import com.kata.borad.entity.Post;
import com.kata.borad.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;

    public List<Post> selectAll(){
        List<Post> postList = postRepository.findAll();
        return postList;
    }
}
