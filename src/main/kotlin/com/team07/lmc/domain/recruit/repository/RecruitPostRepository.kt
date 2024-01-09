package com.team07.lmc.domain.recruit.repository

import com.team07.lmc.domain.recruit.entity.RecruitPostEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RecruitPostRepository: JpaRepository<RecruitPostEntity, Long> {
}