package com.team07.lmc.domain.community.repository

import com.team07.lmc.domain.community.entity.CommunityPostEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CommunityPostEntityRepository: JpaRepository<CommunityPostEntity, Long> {
}