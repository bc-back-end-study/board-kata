package com.kata.boardkata.service;

import com.kata.boardkata.entity.Post;
import com.kata.boardkata.entity.User;
import com.kata.boardkata.model.Vo.PostVo;
import com.kata.boardkata.model.response.BaseResponse;
import com.kata.boardkata.repository.PostRepository;
import com.kata.boardkata.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    public void testInsertPost() {
        // Given
        String userId = "testUser";
        PostVo postVo = new PostVo(1L,"test","testContent",0,
                LocalDateTime.now(),LocalDateTime.now(),"ksh001");
        postVo.setUserId(userId);

        User user = new User();
        when(userRepository.findByUsername(userId)).thenReturn(user);

        // When
        BaseResponse<PostVo> result = postService.insertPost(postVo);

        // Then
        verify(userRepository, times(1)).findByUsername(userId);
        verify(postRepository, times(1)).save(any(Post.class));
        assertNotNull(result);
        assertEquals(postVo, result.getBody());
    }

}
