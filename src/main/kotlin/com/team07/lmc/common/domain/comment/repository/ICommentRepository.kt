package com.team07.lmc.common.domain.comment.repository

import com.team07.lmc.common.domain.comment.entity.CommentEntity
import com.team07.lmc.domain.community.entity.CommunityPostEntity
import com.team07.lmc.domain.recruit.entity.RecruitPostEntity

interface ICommentRepository {
    fun addComment(entity: CommentEntity): CommentEntity
    fun getRecruitPostCommentListByEntity(recruitPostEntity: RecruitPostEntity): List<CommentEntity>
    fun getCommunityPostCommentListByEntity(communityPostEntity: CommunityPostEntity): List<CommentEntity>

}