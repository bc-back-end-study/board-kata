package com.kata.board.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class postList {
    private Long id;
    private String title;
    private String userName;
    private int view;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
