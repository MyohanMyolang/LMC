package com.team07.lmc.domain.recruit.dto

import com.team07.lmc.common.domain.comment.dto.CommentResponse

data class RecruitmentPostWithCommentListResponse (
	val recruitPost: RecruitmentPostResponse,
	val commentList: List<CommentResponse>
)