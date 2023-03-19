package com.kata.board.entity

import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Entity
class Post constructor(

    @Comment("제목")
    private var title: String,

    @Column(columnDefinition = "TEXT")
    @Comment("내용")
    private var content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private val user: User

) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Comment("조회수")
    private var view: Int = 0
}