package com.team07.lmc.common.domain.comment.repository

import com.team07.lmc.common.domain.comment.entity.CommentEntity
import com.team07.lmc.domain.community.entity.CommunityPostEntity
import com.team07.lmc.domain.recruit.entity.RecruitPostEntity
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
}