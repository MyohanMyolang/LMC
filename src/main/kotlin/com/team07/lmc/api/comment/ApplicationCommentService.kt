package com.team07.lmc.api.comment

import com.team07.lmc.common.domain.comment.dto.CommentAddRequest
import com.team07.lmc.common.domain.comment.dto.UpdateCommentRequest
import com.team07.lmc.common.domain.comment.service.CommentService
import com.team07.lmc.common.domain.comment.type.PostType
import com.team07.lmc.common.domain.member.auth.IAuth
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired

abstract class ApplicationCommentService(
	private val commentService: CommentService
) {

	@Autowired
	private lateinit var auth: IAuth

	@Transactional
	open fun addComment(postId: Long, dto: CommentAddRequest) =
		commentService.addComment(
			PostType.COMMUNITY,
			postId = postId,
			commentAddRequest = dto,
			nickname = auth.getCurrentMemberEntity().nickname
		)

	fun patchComment(id: Long, dto: UpdateCommentRequest) =
		commentService.updateComment(id = id, dto = dto)

	fun deleteComment(id: Long) =
		commentService.deleteComment(id = id)
}