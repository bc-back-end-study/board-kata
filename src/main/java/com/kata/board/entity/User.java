package com.kata.board.entity;

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
public class User {
    @Id
    private Long id;
    private String userName;
    private String password;
    private String nickname;
    private String email;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

}
