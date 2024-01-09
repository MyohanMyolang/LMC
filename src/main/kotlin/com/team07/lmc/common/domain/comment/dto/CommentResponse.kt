package com.team07.lmc.common.domain.comment.dto

import java.time.LocalDateTime

data class CommentResponse (
    val id: Long,
    val writer: String,
    val description: String,
    val date: LocalDateTime,
)