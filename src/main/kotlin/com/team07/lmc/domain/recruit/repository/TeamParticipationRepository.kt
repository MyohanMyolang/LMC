package com.team07.lmc.domain.recruit.repository

import com.team07.lmc.domain.recruit.entity.TeamParticipationEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TeamParticipationRepository: JpaRepository<TeamParticipationEntity, Long> {

    fun existsByRecruitPostIdAndMemberId(recruitPostId: Long, memberId: String): Boolean
}