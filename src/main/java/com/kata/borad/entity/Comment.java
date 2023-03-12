package com.kata.borad.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    private Long id;
    private String reply;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private long postId;
    private long userId;

}
