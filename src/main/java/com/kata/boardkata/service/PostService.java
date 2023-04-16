package com.kata.boardkata.service;

import com.kata.boardkata.entity.Post;
import com.kata.boardkata.entity.User;
import com.kata.boardkata.model.dto.PostDto;
import com.kata.boardkata.model.Vo.PostVo;
import com.kata.boardkata.model.response.BaseResponse;
import com.kata.boardkata.model.response.PostResponse;
import com.kata.boardkata.model.response.PostsResponse;
import com.kata.boardkata.repository.PostRepository;
import com.kata.boardkata.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    /**
     * 페이징 게시판 조회
     * @param pageable
     * @return
     */
    public BaseResponse<PostsResponse> getPostPageList(Pageable pageable) {
        return new BaseResponse<>(PostsResponse.makePostResponse(
                postRepository.findAllBy(pageable).stream()
                .map(PostDto::PostToPostDto)
                .collect(Collectors.toList())));
    }

    /**
     * 게시판 등록
     * @param postVo
     * @return
     */
    @Transactional
    public BaseResponse<PostVo> insertPost(PostVo postVo) {
        User user = userRepository.findById(postVo.getUserId())
                .orElseThrow(() -> new CustomException("User not found")); // 커스텀 예외 처리
        postRepository.save(new Post(postVo, user));
        return new BaseResponse<>(postVo);
    }

    @Transactional
    public BaseResponse<PostResponse> removePost(Long postId) {
        Optional<Post> removePost = postRepository.findById(postId);
        if(removePost.isEmpty()) {
            throw new CustomException("Post not found");
        }
        postRepository.deleteById(postId);
        return new BaseResponse<>(PostResponse.makeToPostResponse(removePost.get()));
    }
}