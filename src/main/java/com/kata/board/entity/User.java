package com.kata.board.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    String username;
    String password;
    String nickname;
    String email;
    @Column(name = "created_date")

    LocalDateTime createdDate;
    @Column(name = "modified_date")

    LocalDateTime modifiedDate;
}
