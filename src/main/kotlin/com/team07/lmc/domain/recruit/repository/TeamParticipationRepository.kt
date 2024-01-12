package com.team07.lmc.domain.recruit.repository

import com.team07.lmc.common.domain.member.entity.MemberEntity
import com.team07.lmc.domain.recruit.dto.TeamParticipationResponse
import com.team07.lmc.domain.recruit.entity.RecruitPostEntity
import com.team07.lmc.domain.recruit.entity.TeamParticipationEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TeamParticipationRepository: JpaRepository<TeamParticipationEntity, Long> {

    fun findByRecruitPostId(recruitPostId: RecruitPostEntity): List<TeamParticipationEntity>
    fun existsByRecruitPostIdAndMemberId(recruitPostId: RecruitPostEntity, memberId: MemberEntity): Boolean
}