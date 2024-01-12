package com.team07.lmc.api.community.service

import com.team07.lmc.api.comment.ApplicationCommentService
import com.team07.lmc.common.domain.comment.service.CommentService
import com.team07.lmc.common.domain.comment.type.PostType
import com.team07.lmc.domain.community.dto.CommunityPostResponse
import com.team07.lmc.domain.community.dto.CommunityPostRequest
import com.team07.lmc.domain.community.dto.CommunityPostWithCommentListResponse
import com.team07.lmc.domain.community.service.CommunityPostEntityService
import org.springframework.stereotype.Service

@Service
class CommunityPostService(
	private val communityPostEntityService: CommunityPostEntityService,
	private val commentService: CommentService
) : ApplicationCommentService(commentService = commentService) {
	fun createCommunityPost(communityPostRequest: CommunityPostRequest): CommunityPostResponse {
		return communityPostEntityService.createCommunityPost(communityPostRequest)
	}

	fun getCommunityPost(postId: Long) =
		communityPostEntityService.getCommunityPost(postId).let { postResponse ->
			commentService.getCommentList(PostType.COMMUNITY, postResponse.id)
				.let { CommunityPostWithCommentListResponse(postResponse, it) }
		}


	fun getCommunityPostList(): List<CommunityPostResponse> {
		return communityPostEntityService.getCommunityPostList()
	}

	fun updateCommunityPost(
		postId: Long,
		updateCommunityPostRequest: CommunityPostRequest
	): CommunityPostResponse {
		return communityPostEntityService.updateCommunityPost(postId, updateCommunityPostRequest)
	}

	fun deleteCommunityPost(postId: Long) {
		communityPostEntityService.deleteCommunityPost(postId)
	}
}