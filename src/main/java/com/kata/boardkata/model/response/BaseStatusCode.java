package com.kata.boardkata.model.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.awt.image.PixelGrabber;

@Getter
@RequiredArgsConstructor
public enum BaseStatusCode {
    SUCCESS(200,"success");

    private final int status;
    private final String message;

}
