package com.team07.lmc.domain.community.dto

import java.time.LocalDateTime

data class CommunityPostResponse(
    val id: Long,
    val title: String,
    val content: String,
    val writer: String,
    val create_at: LocalDateTime
)
