package com.team07.lmc.domain.recruit.entity

import jakarta.persistence.*

@Entity
@Table(name = "team_participation")
class TeamParticipationEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parti_id")
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruit_post_id")
    val recruitPostEntity: RecruitPostEntity,

    @Column(name = "consent_status")
    val consentStatus: Boolean
) {
}