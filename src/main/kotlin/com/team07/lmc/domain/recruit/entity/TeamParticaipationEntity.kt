package com.team07.lmc.domain.recruit.entity

import com.team07.lmc.common.domain.member.entity.MemberEntity
import com.team07.lmc.domain.recruit.dto.RecruitmentPostResponse
import com.team07.lmc.domain.recruit.dto.TeamParticipationResponse
import jakarta.persistence.*

@Entity
@Table(name = "team_participation")
class TeamParticipationEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruit_post_id")
    val recruitPostId: RecruitPostEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    var memberId: MemberEntity,

    @Enumerated(EnumType.STRING)
    @Column(name = "answer_status")
    val answer: AnswerStatus = AnswerStatus.WAITING,

    @Column(name = "user_pr")
    val userPr: String
) {
}
fun TeamParticipationEntity.toResponseDTO(): TeamParticipationResponse {
    return TeamParticipationResponse(
        id = id!!,
        userName = memberId.nickname,
        teamName = recruitPostId.teamName,
        consentStatus = answer
    )
}