package com.team07.lmc.domain.recruit.service

import com.team07.lmc.common.domain.member.repository.MemberEntityRepository
import com.team07.lmc.common.domain.member.repository.UserRepository
import com.team07.lmc.domain.recruit.dto.ApplyTeamRequest
import com.team07.lmc.domain.recruit.dto.ChooseApproveRequest
import com.team07.lmc.domain.recruit.dto.TeamParticipationResponse
import com.team07.lmc.domain.recruit.entity.AnswerStatus
import com.team07.lmc.domain.recruit.entity.TeamParticipationEntity
import com.team07.lmc.domain.recruit.entity.toResponseDTO
import com.team07.lmc.domain.recruit.repository.RecruitPostRepository
import com.team07.lmc.domain.recruit.repository.TeamParticipationRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ParticipantService(
    private val recruitPostRepository: RecruitPostRepository,
    private val memberEntityRepository: MemberEntityRepository,
    private val teamParticipationRepository: TeamParticipationRepository
) {
    fun sendJoinRequest(postId: Long, request: ApplyTeamRequest): TeamParticipationResponse {
        val recruitPost = recruitPostRepository.findByIdOrNull(postId) ?: TODO("에외처리")
        val member = memberEntityRepository.findByIdOrNull(request.userId) ?: TODO("에외처리")
        if(recruitPost.isClosed()){
            TODO("예외처리")
        }
        if(teamParticipationRepository.existsByRecruitPostIdAndMemberId(postId, member.memberId)){
            TODO("중복 시 예외처리")
        }
        val teamParticipation = TeamParticipationEntity(
            recruitPostId = recruitPost,
            memberId = member,
            userPr = request.userPr
        )

        return teamParticipationRepository.save(teamParticipation).toResponseDTO()

    }

    // 신청 내역 조회
    fun getAllParticipantsRequest(postId: Long): List<TeamParticipationResponse> {
        return teamParticipationRepository.findByRecruitPostId(postId).map { it.toResponseDTO() }
    }

    // 신청 승인/거부
    fun chooseApproveOrNot(
        postId: Long,
        participantsId: Long,
        request: ChooseApproveRequest
    ): TeamParticipationResponse{
        val recruitPost = recruitPostRepository.findByIdOrNull(postId) ?: TODO("에외처리")
        val participationRequest = teamParticipationRepository.findByIdOrNull(participantsId) ?: TODO("에외처리")

        if(participationRequest.isProceeded()){
            TODO("이미 처리된 요청")
        }
        if(recruitPost.isClosed()){
            TODO("정원이 꽉 찼을 경우")
        }
        when(request.consentStatus){
            AnswerStatus.APPROVED.name -> {
                participationRequest.approval()
                recruitPost.addApplicants()
                if (recruitPost.isFull()) recruitPost.close()
                recruitPostRepository.save(recruitPost)
            }
            AnswerStatus.REJECTED.name -> {
                participationRequest.reject()
            }
            else -> TODO("예외처리")
        }
        return teamParticipationRepository.save(participationRequest).toResponseDTO()
    }

}


