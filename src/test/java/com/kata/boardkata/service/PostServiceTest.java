package com.kata.boardkata.service;

import com.kata.boardkata.entity.Post;
import com.kata.boardkata.entity.User;
import com.kata.boardkata.model.Vo.PostVo;
import com.kata.boardkata.model.response.BaseResponse;
import com.kata.boardkata.model.response.PostResponse;
import com.kata.boardkata.repository.PostRepository;
import com.kata.boardkata.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Mock
    private UserRepository userRepository;
    @Test
    @DisplayName("게시판 생성 성공하는 테스트")
    public void testInsertPost() {
        // Given
        PostVo postVo = new PostVo(1L,"test","testContent",0,
                LocalDateTime.now(),LocalDateTime.now(),1L);
        User user = new User();
        when(userRepository.findById(eq(postVo.getUserId()))).thenReturn(Optional.of(user));

        // When
        BaseResponse<PostVo> result = postService.insertPost(postVo);

        // Then
        verify(userRepository, times(1)).findById(eq(postVo.getUserId()));
        verify(postRepository, times(1)).save(any(Post.class));
        assertNotNull(result);
        assertEquals(postVo, result.getBody());
    }

    @DisplayName("게시판 생성 실패하는 테스트")
    @Test
    public void testInsertPostWithNonExistingUser() {
        // Given
        PostVo postVo = new PostVo(1L,"test","testContent",0,
                LocalDateTime.now(),LocalDateTime.now(),1L);
        when(userRepository.findById(eq(postVo.getUserId()))).thenReturn(Optional.empty());

        // When/Then
        assertThrows(CustomException.class, () -> postService.insertPost(postVo));
        verify(userRepository, times(1)).findById(eq(postVo.getUserId()));
        verify(postRepository, times(0)).save(any(Post.class));
    }

    @Test
    @Transactional
    @DisplayName("게시판 삭제 성공하는 테스트")
    public void testRemovePostSuccess() {
        // 테스트에 필요한 데이터 설정
        Long postId = 1L;
        Post post = new Post(postId,"test","testContent");
        Optional<Post> optionalPost = Optional.of(post);

        // postRepository.findById() 메소드의 동작 설정
        when(postRepository.findById(postId)).thenReturn(optionalPost);

        // postRepository.deleteById() 메소드의 동작 설정
        doNothing().when(postRepository).deleteById(postId);

        // removePost() 메소드 호출
        BaseResponse<PostResponse> result = (BaseResponse<PostResponse>) postService.removePost(postId);

        // 검증: postRepository.findById() 메소드가 호출되었는지 확인
        verify(postRepository, times(1)).findById(postId);
        // 검증: postRepository.deleteById() 메소드가 호출되었는지 확인
        verify(postRepository, times(1)).deleteById(postId);

        // 결과 검증
        assertNotNull(result);
        // 필요에 따라 결과값에 대한 추가적인 검증 로직 작성
    }
    @Test
    @Transactional
    @DisplayName("게시판 삭제 실패하는 테스트")
    public void testRemovePostNotFound() {
        // 테스트에 필요한 데이터 설정
        Long postId = 1L;
        Optional<Post> optionalPost = Optional.empty();

        // postRepository.findById() 메소드의 동작 설정
        when(postRepository.findById(postId)).thenReturn(optionalPost);

        // removePost() 메소드 호출
        assertThrows(CustomException.class, () -> postService.removePost(postId));

        // 검증: postRepository.findById() 메소드가 호출되었는지 확인
        verify(postRepository, times(1)).findById(postId);
        // 검증: postRepository.deleteById() 메소드가 호출되지 않았는지 확인
        verify(postRepository, never()).deleteById(anyLong());
    }
}
