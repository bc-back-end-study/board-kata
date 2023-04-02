package com.kata.board.post.domain

import com.kata.board.entity.BaseEntity
import com.kata.board.entity.User
import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Entity
class Post(
    title: String,
    content: String,
    user: User
): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    private set

    @Comment("조회 수")
    var view: Int = 0
    private set

    @Comment("제목")
    var title: String = title
    private set

    @Comment("내용")
    @Column(columnDefinition = "TEXT")
    var content: String = content
    private set

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var user: User? = user
    private set

}
