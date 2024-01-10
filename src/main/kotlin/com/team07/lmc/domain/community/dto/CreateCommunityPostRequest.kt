package com.team07.lmc.domain.community.dto

import java.time.LocalDateTime

data class CreateCommunityPostRequest(
    //멤버
    val title: String,
    val content: String
)
