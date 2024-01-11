package com.team07.lmc.domain.recruit.dto

data class UpdateRecruitmentPostRequest(
    val title: String,
    val content: String,
    val maxApplicants: Long,
    val numApplicants: Long,
    val recruitmentEnd: Boolean
)