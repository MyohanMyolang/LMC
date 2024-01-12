package com.team07.lmc.api.recruit.service

import com.team07.lmc.api.comment.ApplicationCommentService
import com.team07.lmc.common.domain.comment.service.CommentService
import com.team07.lmc.common.domain.comment.type.PostType
import com.team07.lmc.domain.recruit.dto.CreateRecruitmentPostRequest
import com.team07.lmc.domain.recruit.dto.RecruitmentPostResponse
import com.team07.lmc.domain.recruit.dto.RecruitmentPostWithCommentListResponse
import com.team07.lmc.domain.recruit.dto.UpdateRecruitmentPostRequest
import com.team07.lmc.domain.recruit.service.RecruitPostService
import org.springframework.stereotype.Service

@Service
class RecruitPostProcessingService(
	private val recruitPostService: RecruitPostService,
	private val commentService: CommentService
) : ApplicationCommentService(commentService) {

	fun getAllRecruitmentPosts(): List<RecruitmentPostResponse> {
		return recruitPostService.getAllRecruitmentPosts()
	}

	fun getRecruitmentPostById(postId: Long) =
		recruitPostService.getRecruitmentPostById(postId).let { postResponse ->
			commentService.getCommentList(PostType.RECRUIT, postResponse.id)
				.let { RecruitmentPostWithCommentListResponse(postResponse, it) }
		}

	fun createRecruitmentPost(createRecruitmentPostRequest: CreateRecruitmentPostRequest): RecruitmentPostResponse {
		return recruitPostService.createRecruitmentPost(createRecruitmentPostRequest)
	}

	fun updateRecruitmentPost(
		postId: Long,
		updateRecruitmentPostRequest: UpdateRecruitmentPostRequest
	): RecruitmentPostResponse {
		return recruitPostService.updateRecruitmentPost(postId, updateRecruitmentPostRequest)
	}

	fun deleteRecruitmentPost(postId: Long) {
		return recruitPostService.deleteRecruitmentPost(postId)
	}

}