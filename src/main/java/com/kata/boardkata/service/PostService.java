package com.kata.boardkata.service;

import com.kata.boardkata.model.dto.PostDto;
import com.kata.boardkata.model.response.BaseResponse;
import com.kata.boardkata.model.response.PostsResponse;
import com.kata.boardkata.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    /**
     * 페이징 게시판 조회
     * @param pageable
     * @return
     */
    public BaseResponse<PostsResponse> getPostPageList(Pageable pageable) {
        return new BaseResponse<>(PostsResponse.makePostResponse(
                postRepository.findAllBy(pageable).stream()
                .map(PostDto::makeToPostDto)
                .collect(Collectors.toList())));
    }

}