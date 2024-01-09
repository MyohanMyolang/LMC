package com.team07.lmc.common.domain.comment.service

import com.team07.lmc.common.domain.comment.dto.CommentAddRequest
import com.team07.lmc.common.domain.comment.dto.CommentResponse
import com.team07.lmc.common.domain.comment.entity.CommentEntity
import com.team07.lmc.common.domain.comment.repository.ICommentRepository
import com.team07.lmc.domain.community.entity.CommunityPostEntity
import com.team07.lmc.domain.community.repository.ICommunityRepository
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



    /**
     * NOTE:
     *  1. Id를 통하여 Entity를 얻는다.
     *  2. 받은 updateDto password를 암호화 시킨다.
     *  3. 암호화 시킨 password와 entity에 저장된 암호가 같은지 확인한다.
     *  4. 같다면 update를 진행시킨다.
     */
    fun updateComment(id: Long) {

    }
// TODO: Update와 Delete의 중복 로직에 대하여 Permission Check를 Trailling Lambda로 처리시킨다.
    /**
     * NOTE:
     *  1. Id를 통하여 Entity를 얻는다.
     *  2. 받은 deleteDto Password를 암호화 시킨다.
     *  3. 암호화 시킨 password와 enttiy에 저장된 암호가 같은지 확인한다.
     *  4. 같다면 delete를 진행시킨다.
     */
    fun deleteComment(id: Long) {

    }
}