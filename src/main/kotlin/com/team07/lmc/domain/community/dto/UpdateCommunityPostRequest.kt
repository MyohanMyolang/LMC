package com.team07.lmc.domain.community.dto

import java.time.LocalDateTime

data class UpdateCommunityPostRequest(
    //멤버
    val title: String,
    val content: String
)
