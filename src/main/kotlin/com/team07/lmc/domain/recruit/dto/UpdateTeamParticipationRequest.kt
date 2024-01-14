package com.team07.lmc.domain.recruit.dto

import com.team07.lmc.domain.recruit.entity.AnswerStatus

data class UpdateTeamParticipationRequest(
    var approvalStatus: AnswerStatus
)