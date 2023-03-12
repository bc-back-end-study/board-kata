package com.kata.board.entity

import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Entity
class Post constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    @Comment("제목")
    private val title: String,

    @Column(columnDefinition = "TEXT")
    @Comment("내용")
    private val content: String,

    @Comment("닉네임")
    private val view: Int,

    @Comment("이메일")
    private val email: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private val user: User
): BaseEntity()