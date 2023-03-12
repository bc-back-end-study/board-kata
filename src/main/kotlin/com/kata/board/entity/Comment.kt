package com.kata.board.entity

import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Entity
class Comment constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    @Column(columnDefinition = "TEXT")
    @Comment("댓글")
    private var reply: String,

    @ManyToOne(fetch = FetchType.LAZY)
    private val post: Post,

    @ManyToOne(fetch = FetchType.LAZY)
    private val user: User
) : BaseEntity()