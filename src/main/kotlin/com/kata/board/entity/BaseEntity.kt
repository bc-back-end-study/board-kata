package com.kata.board.entity

import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
open class BaseEntity {

    @CreatedDate
    private val createdDate: LocalDateTime = LocalDateTime.MIN

    @LastModifiedDate
    private lateinit var modifiedDate: LocalDateTime
}