package com.team07.lmc.common.domain.comment.service

import com.team07.lmc.common.domain.comment.dto.CommentAddRequest
import com.team07.lmc.common.domain.comment.dto.DeleteCommentRequest
import com.team07.lmc.common.domain.comment.dto.UpdateCommentRequest
import com.team07.lmc.common.domain.comment.entity.CommentEntity
import com.team07.lmc.common.domain.comment.repository.ICommentRepository
import com.team07.lmc.domain.community.entity.CommunityPostEntity
import com.team07.lmc.domain.recruit.entity.RecruitPostEntity
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CommentService(
    private val commentRepository: ICommentRepository
) {
    @Transactional
    fun addRecruitPostComment(recruitPostEntity: RecruitPostEntity, commentAddRequest: CommentAddRequest) =
        CommentEntity.of(recruitPostEntity, commentAddRequest)
            .let { commentRepository.addComment(it) }.toResponse()

    @Transactional
    fun addCommunityPostComment(communityPostEntity: CommunityPostEntity, commentAddRequest: CommentAddRequest) =
        CommentEntity.of(communityPostEntity, commentAddRequest)
            .let { commentRepository.addComment(it) }.toResponse()

    fun getRecruitPostCommentList(recruitPostEntity: RecruitPostEntity) =
        commentRepository.getRecruitPostCommentListByEntity(recruitPostEntity)
            .let { it.map { comment -> comment.toResponse() } }


    fun getCommunityPostCommentList(communityPostEntity: CommunityPostEntity) =
        commentRepository.getCommunityPostCommentListByEntity(communityPostEntity)
            .let { it.map { comment -> comment.toResponse() } }


    private fun <T> checkPermission(password: String, id: Long, func: (entity: CommentEntity) -> T): T =
        commentRepository.findById(id)
            .also { if (!it.checkPassword(password)) TODO("권한 없음") }
            .let { func(it) }

    @Transactional
    fun updateComment(id: Long, dto: UpdateCommentRequest) = checkPermission(dto.password, id){
        commentRepository.updateEntity(it, dto).toResponse()
    }

    @Transactional
    fun deleteComment(id: Long, dto: DeleteCommentRequest) = checkPermission(dto.password, id){
        commentRepository.deleteEntity(it).toResponse()
    }
}