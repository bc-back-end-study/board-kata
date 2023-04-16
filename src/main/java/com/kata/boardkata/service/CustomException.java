package com.kata.boardkata.service;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}