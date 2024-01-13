package com.team07.lmc.common.domain.comment.repository

import com.team07.lmc.common.domain.comment.dto.UpdateCommentRequest
import com.team07.lmc.common.domain.comment.entity.CommentEntity
import com.team07.lmc.common.domain.comment.type.PostType
import com.team07.lmc.global.exceptions.NotFoundTargetException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class CommentRepository(
	private val commentEntityRepository: CommentEntityRepository
) : ICommentRepository {
	override fun addComment(entity: CommentEntity) =
		commentEntityRepository.save(entity)

	override fun findById(id: Long): CommentEntity =
		commentEntityRepository.findByIdOrNull(id) ?: throw NotFoundTargetException("")

	override fun updateEntity(entity: CommentEntity, dto: UpdateCommentRequest): CommentEntity =
		entity.apply {
			dto.description?.let { this.description = it }
		}

	override fun deleteEntity(entity: CommentEntity): CommentEntity =
		entity.apply { commentEntityRepository.delete(this) }

	override fun getCommentListByPostTypeAndPostId(postType: PostType, postId: Long): List<CommentEntity> =
		commentEntityRepository.getCommentEntitiesByPostTypeAndPostId(postType, postId)
}