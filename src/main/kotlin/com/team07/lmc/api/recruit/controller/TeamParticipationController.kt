package com.team07.lmc.api.recruit.controller

import com.team07.lmc.api.recruit.service.ParticipantProcessingService
import com.team07.lmc.domain.recruit.dto.ApplyTeamRequest
import com.team07.lmc.domain.recruit.dto.ChooseApproveRequest
import com.team07.lmc.domain.recruit.dto.TeamParticipationResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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
            .status(HttpStatus.CREATED)
            .body(participantService.sendJoinRequest(postId, applyTeamRequest))
    }

    // 팀 신청 내역 조회
    @GetMapping
    fun getAllParticipantsRequest(@PathVariable postId: Long): ResponseEntity<List<TeamParticipationResponse>>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(participantService.getAllParticipantsRequest(postId))
    }

    // 팀 신청 내역 승인 or 거절
    @PatchMapping("/{participantsId}")
    fun chooseApproveOrNot(
        @PathVariable postId: Long,
        @PathVariable participantsId: Long,
        @RequestBody chooseApproveRequest: ChooseApproveRequest
    ): ResponseEntity<TeamParticipationResponse>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(participantService.chooseApproveOrNot(postId, participantsId, chooseApproveRequest))
    }
}