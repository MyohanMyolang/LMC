package com.team07.lmc.domain.post.repository

import com.team07.lmc.domain.post.entity.CommunityPostEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostEntityRepository: JpaRepository<CommunityPostEntity, Long> {
}