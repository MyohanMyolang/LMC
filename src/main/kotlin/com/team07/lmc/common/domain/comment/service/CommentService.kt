package com.team07.lmc.common.domain.comment.service

import com.team07.lmc.common.domain.comment.dto.CommentAddRequest
import com.team07.lmc.common.domain.comment.dto.UpdateCommentRequest
import com.team07.lmc.common.domain.comment.entity.CommentEntity
import com.team07.lmc.common.domain.comment.repository.ICommentRepository
import com.team07.lmc.common.domain.comment.type.PostType
import com.team07.lmc.common.domain.member.auth.IAuth
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CommentService(
	private val commentRepository: ICommentRepository,
	private val auth: IAuth
) {
	@Transactional
	fun addComment(postType: PostType, postId: Long, commentAddRequest: CommentAddRequest) =
		auth.getCurrentMemberEntity()
			.let { CommentEntity.of(postType, postId, it, commentAddRequest) }
			.let { commentRepository.addComment(it) }.toResponse()

	fun getCommentList(postType: PostType, postId: Long) =
		commentRepository.getCommentListByPostTypeAndPostId(postType, postId)
			.let { it.map { comment -> comment.toResponse() } }

	private fun <T> checkPermission(id: Long, func: (commentEntity: CommentEntity) -> T): T =
		commentRepository.findById(id).let {
			auth.checkPermission(it.member) { func.invoke(it) }
		}

	@Transactional
	fun updateComment(id: Long, dto: UpdateCommentRequest) = checkPermission(id) {
		commentRepository.updateEntity(it, dto).toResponse()
	}

	@Transactional
	fun deleteComment(id: Long) = checkPermission(id) {
		commentRepository.deleteEntity(it).toResponse()
	}
}