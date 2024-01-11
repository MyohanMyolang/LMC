package com.team07.lmc.domain.recruit.dto

import java.time.LocalDateTime

data class RecruitmentPostResponse (
    val id: Long,
    val teamName: String,
    val date: LocalDateTime,
    val content: String,
    val maxApplicants: Long,
    val numApplicants: Long,
    val recruitmentEnd: Boolean
    )
