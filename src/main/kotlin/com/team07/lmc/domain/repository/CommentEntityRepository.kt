package com.team07.lmc.domain.repository

import com.team07.lmc.domain.entity.CommentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CommentEntityRepository : JpaRepository<CommentEntity, Long> {
}