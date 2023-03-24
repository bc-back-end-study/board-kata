package com.kata.boardkata.service;

import com.kata.boardkata.entity.Post;
import com.kata.boardkata.entity.User;
import com.kata.boardkata.model.dto.PostDto;
import com.kata.boardkata.model.response.BaseResponse;
import com.kata.boardkata.model.response.PostsResponse;
import com.kata.boardkata.repository.PostRepository;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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