package com.team07.lmc.domain.community.dto

import java.time.LocalDateTime

data class CreateCommunityPostRequest(
    val title: String,
    val content: String,
    val writer: String,
    val create_at: LocalDateTime
)
