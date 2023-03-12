package com.kata.borad.entity;

import lombok.Getter;

@Getter
public class User {
    private long id;
    private String userName;
    private String password;
    private String nickname;
    private String email;

    public User(long id, String userName, String password, String nickname, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }
}
