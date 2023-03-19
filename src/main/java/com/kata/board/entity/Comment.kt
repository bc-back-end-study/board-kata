package com.kata.board.entity

import jakarta.persistence.*

@Entity
class Comment(
    @Column(nullable = false)
    val reply: String,

    @ManyToOne(fetch = FetchType.LAZY)
    var post: Post? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    var user: User? = null
): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
