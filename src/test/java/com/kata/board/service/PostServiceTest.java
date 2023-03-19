package com.kata.board.service;

import com.kata.board.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PostServiceTest {
    @Autowired
    private PostService postService;

    @Test
    void selectAll() {

        List<Post> testList = postService.selectAll();
        for(Post p : testList) {
            System.out.println(p.getTitle() + " " + p.getContent());
        }

    }
}