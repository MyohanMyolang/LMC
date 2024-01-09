package com.team07.lmc.common.domain.comment.repository

import com.team07.lmc.common.domain.comment.dto.UpdateCommentRequest
import com.team07.lmc.common.domain.comment.entity.CommentEntity
import com.team07.lmc.domain.community.entity.CommunityPostEntity
import com.team07.lmc.domain.recruit.entity.RecruitPostEntity
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class CommentRepository(
    private val commentEntityRepository: CommentEntityRepository
) : ICommentRepository {
    override fun addComment(entity: CommentEntity) =
        commentEntityRepository.save(entity)

    override fun getRecruitPostCommentListByEntity(recruitPostEntity: RecruitPostEntity) =
        commentEntityRepository.getCommentEntitiesByRecruitPostEntity(recruitPostEntity)

    override fun getCommunityPostCommentListByEntity(communityPostEntity: CommunityPostEntity) =
        commentEntityRepository.getCommentEntitiesByCommunityPostEntity(communityPostEntity)

    override fun findById(id: Long): CommentEntity = commentEntityRepository.findByIdOrNull(id) ?: TODO("Comment 발견 못함")

    override fun updateEntity(entity: CommentEntity, dto: UpdateCommentRequest): CommentEntity =
        entity.apply {
            dto.description?.let { this.description = it }
        }

    override fun deleteEntity(entity: CommentEntity): CommentEntity =
        entity.apply { commentEntityRepository.delete(this) }
}