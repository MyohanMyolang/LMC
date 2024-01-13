package com.team07.lmc.common.domain.comment.dto

import jakarta.validation.constraints.NotBlank


data class CommentAddRequest(
    @field:NotBlank(message = "내용은 비어있으면 안됩니다.")
    val description: String? = null
)
