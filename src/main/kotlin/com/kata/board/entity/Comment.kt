package com.kata.board.entity

import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Entity
data class Comment (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    @Column(columnDefinition = "TEXT")
    @Comment("댓글")
    private val reply: String,

    @ManyToOne
    private val post: Post,

    @ManyToOne
    private val user: User
): BaseEntity()