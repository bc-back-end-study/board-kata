package com.kata.board.entity

import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Entity
class Post constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    @Comment("제목")
    private var title: String,

    @Column(columnDefinition = "TEXT")
    @Comment("내용")
    private var content: String,

    @Comment("조회수")
    private var view: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private val user: User
) : BaseEntity()