package com.kata.board.controller;

import com.kata.board.dto.PostDto;
import com.kata.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDto> PostDto(){
        return postService.getPostList();
    }




}
