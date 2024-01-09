package com.team07.lmc.common.domain.comment.repository

import com.team07.lmc.common.domain.comment.entity.CommentEntity
import com.team07.lmc.domain.community.entity.CommunityPostEntity
import com.team07.lmc.domain.recruit.entity.RecruitPostEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CommentEntityRepository : JpaRepository<CommentEntity, Long> {
    fun getCommentEntitiesByCommunityPostEntity(communityPostEntity: CommunityPostEntity): List<CommentEntity>
    fun getCommentEntitiesByRecruitPostEntity(recruitPostEntity: RecruitPostEntity): List<CommentEntity>
}