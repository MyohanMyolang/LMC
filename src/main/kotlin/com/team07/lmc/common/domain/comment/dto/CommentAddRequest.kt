package com.team07.lmc.common.domain.comment.dto


data class CommentAddRequest(
    val writer: String,
    val password: String,
    val description: String
)
