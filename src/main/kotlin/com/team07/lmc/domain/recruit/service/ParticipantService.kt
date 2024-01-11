package com.team07.lmc.domain.recruit.service

import com.team07.lmc.common.domain.member.repository.UserRepository
import com.team07.lmc.domain.recruit.dto.ApplyTeamRequest
import com.team07.lmc.domain.recruit.dto.TeamParticipationResponse
import com.team07.lmc.domain.recruit.repository.RecruitPostRepository
import com.team07.lmc.domain.recruit.repository.TeamParticipationRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ParticipantService(
    private val recruitPostRepository: RecruitPostRepository,
    private val userRepository: UserRepository,
    private val teamParticipationRepository: TeamParticipationRepository
) {
    fun sendJoinRequest(postId: Long, request: ApplyTeamRequest): TeamParticipationResponse {
        val recruitPost = recruitPostRepository.findByIdOrNull(postId) ?: TODO("에외처리")
        val member = userRepository.findByIdOrNull(request.userId) ?: TODO("에외처리")
        if(recruitPost.isClosed()){
            TODO("예외처리")
        }
        if(teamParticipationRepository.)
    }

}
