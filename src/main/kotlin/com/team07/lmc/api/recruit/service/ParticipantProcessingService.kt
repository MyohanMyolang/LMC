package com.team07.lmc.api.recruit.service

import com.team07.lmc.domain.recruit.dto.ApplyTeamRequest
import com.team07.lmc.domain.recruit.dto.TeamParticipationResponse
import com.team07.lmc.domain.recruit.service.ParticipantService
import org.springframework.stereotype.Service

@Service
class ParticipantProcessingService(
    private val participantService: ParticipantService
) {
    fun sendJoinRequest(postId: Long, applyTeamRequest: ApplyTeamRequest): TeamParticipationResponse {
        return participantService.sendJoinRequest(postId, applyTeamRequest)
    }
}
