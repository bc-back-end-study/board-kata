package com.kata.board.entity

import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Entity
class User(
    @Comment("유저명")
    private var username: String,

    @Comment("비밀번호")
    private var password: String,

    @Comment("닉네임")
    private var nickname: String,

    @Comment("이메일")
    private val email: String

): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null


}
