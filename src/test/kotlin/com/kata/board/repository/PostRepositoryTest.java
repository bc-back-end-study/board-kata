package com.kata.board.repository;

import com.kata.board.entity.Post;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
class PostRepositoryTest {

    private final PostRepository postRepository;
    @Test
    @DisplayName("게시판 전체 조회 테스트")
    void findAllPost(){
        //given
        List<Post> postList = new ArrayList<>();
        for (int i=0; i< 100; i++) {
            Post post = new Post();
            post.setTitle("test" + i);
            post.setContent(i+ "테스트입니다");
            postList.add(post);
        }
        postRepository.saveAll(postList);
        //when
        List<Post> posts = postRepository.findAll();
        //then
        posts.stream().forEach(post -> System.out.println(post.toString()));
    }

}