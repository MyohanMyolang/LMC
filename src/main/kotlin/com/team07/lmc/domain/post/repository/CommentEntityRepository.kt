package com.team07.lmc.domain.post.repository

import com.team07.lmc.domain.post.entity.CommentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CommentEntityRepository : JpaRepository<CommentEntity, Long> {
}