package com.kata.board.entity;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PostTest {

    @Test
    @DisplayName("조회 수가 0보다 작은 경우 인스턴스 생성 예외")
    void Should_throwException_When_viewCountNegativeValueOrNull() {
        assertThatExceptionOfType(IllegalStateException.class)
            .isThrownBy(() -> Post.builder()
                .user(User.builder().build())
                .view(-5)
                .content("게시글 본문")
                .title("제목")
                .build())
            .withMessage("조회 수는 0보다 작을 수 없습니다.");
    }

}
