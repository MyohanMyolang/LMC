package com.team07.lmc.common.domain.comment.repository

import com.team07.lmc.common.domain.comment.dto.UpdateCommentRequest
import com.team07.lmc.common.domain.comment.entity.CommentEntity
import com.team07.lmc.common.domain.comment.type.PostType

interface ICommentRepository {
    fun addComment(entity: CommentEntity): CommentEntity
    fun findById(id: Long): CommentEntity
    fun updateEntity(entity: CommentEntity, dto: UpdateCommentRequest): CommentEntity
    fun deleteEntity(entity: CommentEntity): CommentEntity
    fun getCommentListByPostTypeAndPostId(postType: PostType, postId: Long): List<CommentEntity>

}