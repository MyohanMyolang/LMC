package com.team07.lmc.domain.recruit.service

import com.team07.lmc.common.domain.member.auth.IAuth
import com.team07.lmc.domain.recruit.dto.ApplyTeamRequest
import com.team07.lmc.domain.recruit.dto.ChooseApproveRequest
import com.team07.lmc.domain.recruit.dto.TeamParticipationResponse
import com.team07.lmc.domain.recruit.entity.AnswerStatus
import com.team07.lmc.domain.recruit.entity.TeamParticipationEntity
import com.team07.lmc.domain.recruit.exceptions.ClosedException
import com.team07.lmc.domain.recruit.exceptions.DuplicatedException
import com.team07.lmc.domain.recruit.exceptions.NoOptionException
import com.team07.lmc.domain.recruit.exceptions.ProceededException
import com.team07.lmc.domain.recruit.repository.RecruitPostRepository
import com.team07.lmc.domain.recruit.repository.TeamParticipationRepository
import com.team07.lmc.global.exceptions.NotFoundTargetException
import jakarta.transaction.Transactional
import org.hibernate.annotations.NotFound
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ParticipantService(
	private val recruitPostRepository: RecruitPostRepository,
	private val teamParticipationRepository: TeamParticipationRepository,
	private val auth: IAuth
) {
	fun sendJoinRequest(postId: Long, request: ApplyTeamRequest): TeamParticipationResponse {
		val recruitPost =
			recruitPostRepository.findByIdOrNull(postId) ?: throw NotFoundTargetException("해당 Post가 존재하지 않습니다.")
		val member = auth.getCurrentMemberEntity()
		if (recruitPost.isClosed()) {
			throw ClosedException("닫힌 신청입니다.")
		}
		if (teamParticipationRepository.existsByRecruitPostIdAndMemberId(recruitPost, member)) {
			throw DuplicatedException("중복된 신청입니다.")
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

		return recruitPostRepository.findByIdOrNull(postId)?.let {
			auth.checkPermission(it.memberEntity) {
				teamParticipationRepository.findByRecruitPostId(it).map { entity -> entity.toResponseDTO() }
			}
		} ?: throw NotFoundTargetException("해당 Post가 존재하지 않습니다.")
	}

	// 신청 승인/거부
	@Transactional
	fun chooseApproveOrNot(
		postId: Long,
		participantsId: Long,
		request: ChooseApproveRequest
	): TeamParticipationResponse {
		val recruitmentPost =
			recruitPostRepository.findByIdOrNull(postId) ?: throw NotFoundTargetException("해당 Post가 존재하지 않습니다.")
		val participationRequest = teamParticipationRepository.findByIdOrNull(participantsId)
			?: throw NotFoundTargetException("해당 Post가 존재하지 않습니다.")
		auth.checkPermission(recruitmentPost.memberEntity) {
			if (participationRequest.isProceeded()) {
				throw ProceededException("이미 처리된 신청입니다.")
			}
			if (recruitmentPost.isClosed()) {
				throw ClosedException("닫힌 신청입니다.")
			}
			when (request.consentStatus) {
				AnswerStatus.APPROVED -> {
					participationRequest.approval()
					recruitmentPost.addApplicants()
					if (recruitmentPost.isFull()) recruitmentPost.close()
					recruitPostRepository.save(recruitmentPost)
				}

				AnswerStatus.REJECTED -> {
					participationRequest.reject()
				}

				else -> throw NoOptionException("해당 요청은 존재하지 않습니다.")
			}
		}


		return teamParticipationRepository.save(participationRequest).toResponseDTO()
	}

}


