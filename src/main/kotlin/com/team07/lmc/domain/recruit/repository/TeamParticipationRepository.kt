package com.team07.lmc.domain.recruit.repository

import com.team07.lmc.domain.recruit.entity.TeamParticipationEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TeamParticipationRepository: JpaRepository<TeamParticipationEntity, Long> {
    fun findByMemberEntityId(userId: Long): List<TeamParticipationEntity>

    fun existsByPostIdAndUserId(postId: Long, userId: Long): Boolean
}