package com.team07.lmc.domain.recruit.dto

import com.team07.lmc.domain.recruit.entity.AnswerStatus


data class TeamParticipationResponse(
    val id: Long,
    val userName: String,
    val teamName: String,
    val consentStatus: AnswerStatus

)
