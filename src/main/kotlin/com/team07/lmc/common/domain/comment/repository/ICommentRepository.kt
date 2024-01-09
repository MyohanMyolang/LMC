package com.team07.lmc.common.domain.comment.repository

import com.team07.lmc.common.domain.comment.dto.UpdateCommentRequest
import com.team07.lmc.common.domain.comment.entity.CommentEntity
import com.team07.lmc.domain.community.entity.CommunityPostEntity
import com.team07.lmc.domain.recruit.entity.RecruitPostEntity

interface ICommentRepository {
    fun addComment(entity: CommentEntity): CommentEntity
    fun getRecruitPostCommentListByEntity(recruitPostEntity: RecruitPostEntity): List<CommentEntity>
    fun getCommunityPostCommentListByEntity(communityPostEntity: CommunityPostEntity): List<CommentEntity>
    fun findById(id: Long): CommentEntity
    fun updateEntity(entity: CommentEntity, dto: UpdateCommentRequest): CommentEntity
    fun deleteEntity(entity: CommentEntity): CommentEntity

}