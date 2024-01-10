package com.team07.lmc.common.domain.comment.service

import com.team07.lmc.common.domain.comment.dto.CommentAddRequest
import com.team07.lmc.common.domain.comment.dto.DeleteCommentRequest
import com.team07.lmc.common.domain.comment.dto.UpdateCommentRequest
import com.team07.lmc.common.domain.comment.entity.CommentEntity
import com.team07.lmc.common.domain.comment.repository.ICommentRepository
import com.team07.lmc.common.domain.comment.type.PostType
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CommentService(
	private val commentRepository: ICommentRepository
) {
	@Transactional
	fun addComment(postType: PostType, postId: Long, nickname: String, commentAddRequest: CommentAddRequest) =
		CommentEntity.of(postType, postId, nickname, commentAddRequest)
			.let { commentRepository.addComment(it) }.toResponse()

	fun getCommentList(postType: PostType, postId: Long) =
		commentRepository.getCommentListByPostTypeAndPostId(postType, postId)
			.let { it.map { comment -> comment.toResponse() } }


	private fun <T> checkPermission(password: String, id: Long, func: (entity: CommentEntity) -> T): T =
		commentRepository.findById(id)
			.also { if (!it.checkPassword(password)) TODO("권한 없음") }
			.let { func(it) }

	@Transactional
	fun updateComment(id: Long, dto: UpdateCommentRequest) = checkPermission(dto.password, id) {
		commentRepository.updateEntity(it, dto).toResponse()
	}

	@Transactional
	fun deleteComment(id: Long, dto: DeleteCommentRequest) = checkPermission(dto.password, id) {
		commentRepository.deleteEntity(it).toResponse()
	}
}