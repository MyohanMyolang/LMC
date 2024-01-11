package com.team07.lmc.domain.community.dto

import java.time.LocalDateTime

data class UpdateCommunityPostRequest(
    val title: String,
    val content: String,
    val writer: String
)
