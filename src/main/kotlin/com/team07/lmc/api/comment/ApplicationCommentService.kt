package com.team07.lmc.api.comment

import com.team07.lmc.common.domain.comment.dto.CommentAddRequest
import com.team07.lmc.common.domain.comment.dto.UpdateCommentRequest
import com.team07.lmc.common.domain.comment.service.CommentService
import com.team07.lmc.common.domain.comment.type.PostType
import org.springframework.stereotype.Component

@Component
abstract class ApplicationCommentService(
	private val commentService: CommentService
) {
	fun addComment(postId: Long, dto: CommentAddRequest) =
		commentService.addComment(PostType.COMMUNITY, postId = postId, commentAddRequest = dto, nickname = dto.writer)

	fun patchComment(id: Long, dto: UpdateCommentRequest) =
		commentService.updateComment(id = id, dto = dto)

	fun deleteComment(id: Long) =
		commentService.deleteComment(id = id)
}