package com.team07.lmc.domain.recruit.entity

import com.team07.lmc.common.domain.member.entity.MemberEntity
import jakarta.persistence.*

@Entity
@Table(name = "team_participation")
class TeamParticipationEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruit_post_id")
    val recruitPostEntity: RecruitPostEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    var memberEntity: MemberEntity,

    @Enumerated(EnumType.STRING)
    @Column(name = "answer_status")
    val answer: AnswerStatus,

    @Column(name = "user_pr")
    val userPr: String
) {
}