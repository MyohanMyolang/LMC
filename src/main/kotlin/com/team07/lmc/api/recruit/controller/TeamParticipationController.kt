package com.team07.lmc.api.recruit.controller

import com.team07.lmc.api.recruit.service.ParticipantProcessingService
import com.team07.lmc.domain.recruit.dto.ApplyTeamRequest
import com.team07.lmc.domain.recruit.dto.TeamParticipationResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/recruitment/post/{postId}/participants")
class TeamParticipationController(
    private val participantService: ParticipantProcessingService
) {
    @PostMapping
    fun participateRequest(
        @PathVariable postId: Long,
        @RequestBody applyTeamRequest: ApplyTeamRequest
    ): ResponseEntity<TeamParticipationResponse> {

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(participantService.sendJoinRequest(postId, applyTeamRequest))
    }
}