package com.kata.boardkata.model.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BaseStatusCode {
    SUCCESS(200, "success"),
    // 유저 관련 상태코드는 1000 대역 사용
    USER_NOT_FOUND(1000, "User Not Found"),
    // 게시물 관련 상태코드는 1100 대역 사용
    POST_NOT_FOUND(1100,"Post Not Found")
    ;

    private final int status;
    private final String message;

}
