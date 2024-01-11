package com.team07.lmc.api.recruit.service

import com.team07.lmc.domain.recruit.service.ParticipantService
import org.springframework.stereotype.Service

@Service
class ParticipantProcessingService(
    private val participantService: ParticipantService
) {
    fun sendJoinRequest(postId: Long){
        participantService.sendJoinRequest(postId)
    }
}
