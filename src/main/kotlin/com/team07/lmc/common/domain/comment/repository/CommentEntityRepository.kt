package com.team07.lmc.common.domain.comment.repository

import com.team07.lmc.common.domain.comment.entity.CommentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CommentEntityRepository : JpaRepository<CommentEntity, Long> {
}