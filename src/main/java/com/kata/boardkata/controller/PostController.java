package com.kata.boardkata.controller;

import com.kata.boardkata.model.response.BaseResponse;
import com.kata.boardkata.model.response.PostsResponse;
import com.kata.boardkata.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {
    private static final int DEFAULT_PAGE_SIZE = 10;
    private final PostService postService;
    @GetMapping
    public BaseResponse<PostsResponse> getPosts(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = ""+ DEFAULT_PAGE_SIZE) int size
    ){
        return postService.getPostPageList(
                PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"modifiedDate")));
    }
}
