package com.team07.lmc.domain.recruit.dto

import java.time.LocalDateTime


data class CreateRecruitmentPostRequest (
    val title: String,
    val writer: String,
    val content: String,
    val maxApplicants: Long,
    val numApplicants: Long
)