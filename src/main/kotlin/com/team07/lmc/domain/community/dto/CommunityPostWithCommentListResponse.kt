package com.team07.lmc.domain.community.dto

import com.team07.lmc.common.domain.comment.dto.CommentResponse

data class CommunityPostWithCommentListResponse (
	val communityPost: CommunityPostResponse,
	val commentList: List<CommentResponse>
)