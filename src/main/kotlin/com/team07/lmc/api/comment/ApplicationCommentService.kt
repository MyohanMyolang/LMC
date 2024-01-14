package com.team07.lmc.api.comment

import com.team07.lmc.common.domain.comment.dto.CommentAddRequest
import com.team07.lmc.common.domain.comment.dto.CommentResponse
import com.team07.lmc.common.domain.comment.dto.UpdateCommentRequest
import com.team07.lmc.common.domain.comment.service.CommentService
import com.team07.lmc.common.domain.comment.type.PostType
import com.team07.lmc.common.domain.member.auth.IAuth
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired

open class ApplicationCommentService(
	private val postType: PostType,
	private val commentService: CommentService
) {

	open fun addComment(postId: Long, dto: CommentAddRequest) =
		commentService.addComment(
			postType,
			postId = postId,
			commentAddRequest = dto,
		)

	fun patchComment(id: Long, dto: UpdateCommentRequest) =
		commentService.updateComment(id = id, dto = dto)

	fun deleteComment(id: Long) =
		commentService.deleteComment(id = id)

}