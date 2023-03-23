package com.kata.board.service;

import com.kata.board.dto.PostDto;
import com.kata.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
class PostServiceTest {

    private final PostService postService;

    @Test
    @DisplayName("아")
    void test() {
        //given

        //when
        List<PostDto> postDtoList = postService.getPostList();

        //then
        postDtoList.forEach(postDto -> System.out.println(postDto.toString()));
    }

}