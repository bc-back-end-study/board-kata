package com.kata.board.entity

import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Entity
@Table(name = "`user`")
class User(
    username: String,

    password: String,

    nickname: String,

    email: String

): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    private set

    @Comment("유저명")
    var username: String = username
    private set

    @Comment("비밀번호")
    var password: String = password
    private set

    @Comment("닉네임")
    var nickname: String = nickname
    private set

    @Comment("이메일")
    var email: String = email
    private set

}
