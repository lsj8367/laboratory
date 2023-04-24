package com.github.lsj8367.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

class Board (
    @Id
    var id: Long? = null,
    val title: String,
    val content: String,

    @CreatedDate
    val createdAt: LocalDateTime,

    @LastModifiedDate
    val updatedAt: LocalDateTime
) {
}
