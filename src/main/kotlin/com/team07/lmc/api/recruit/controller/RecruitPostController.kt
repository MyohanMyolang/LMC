package com.team07.lmc.api.recruit.controller

import com.team07.lmc.api.recruit.service.RecruitPostProcessingService
import com.team07.lmc.api.util.responseEntity
import com.team07.lmc.common.domain.comment.dto.CommentAddRequest
import com.team07.lmc.common.domain.comment.dto.UpdateCommentRequest
import com.team07.lmc.domain.recruit.dto.CreateRecruitmentPostRequest
import com.team07.lmc.domain.recruit.dto.RecruitmentPostResponse
import com.team07.lmc.domain.recruit.dto.UpdateRecruitmentPostRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/recruitment")
class RecruitPostController(
	private val recruitmentPostService: RecruitPostProcessingService,
) {

	// 모집글 리스트 형태로 조회
	@GetMapping("/posts")
	fun getAllRecruitmentPosts(): ResponseEntity<List<RecruitmentPostResponse>> {
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(recruitmentPostService.getAllRecruitmentPosts())
	}

	// 모집글 상세보기
	@GetMapping("/post/{postId}")
	fun getRecruitmentPostById(@PathVariable postId: Long) =
		ResponseEntity
			.status(HttpStatus.OK)
			.body(recruitmentPostService.getRecruitmentPostById(postId))


	// 모집글 작성
	@PostMapping("/post")
	fun createRecruitmentPost(
		@RequestBody createRecruitmentPostRequest: CreateRecruitmentPostRequest
	): ResponseEntity<RecruitmentPostResponse> {
		return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(recruitmentPostService.createRecruitmentPost(createRecruitmentPostRequest))
	}

	// 모집글 수정
	@PatchMapping("/post/{postId}")
	fun updateRecruitmentPost(
		@PathVariable postId: Long,
		@RequestBody updateRecruitmentPostRequest: UpdateRecruitmentPostRequest
	): ResponseEntity<RecruitmentPostResponse> {
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(recruitmentPostService.updateRecruitmentPost(postId, updateRecruitmentPostRequest))

	}

	// 모집글 삭제
	@DeleteMapping("/post/{postId}")
	fun deleteRecruitmentPost(@PathVariable postId: Long): ResponseEntity<Unit> {
		recruitmentPostService.deleteRecruitmentPost(postId)
		return ResponseEntity
			.status(HttpStatus.NO_CONTENT)
			.build()
	}

	@PostMapping("/post/{postId}/comment")
	fun addComment(
		@PathVariable postId: Long,
		@RequestBody commentAddRequest: CommentAddRequest
	) = responseEntity(HttpStatus.CREATED) {
		recruitmentPostService.addComment(postId, commentAddRequest)
	}

	@PatchMapping("/post/comment/{id}")
	fun patchComment(
		@PathVariable id: Long,
		@RequestBody updateCommentRequest: UpdateCommentRequest
	) = responseEntity(HttpStatus.OK) {
		recruitmentPostService.patchComment(id, updateCommentRequest)
	}

	@DeleteMapping("/post/comment/{id}")
	fun deleteComment(@PathVariable id: Long) = responseEntity(HttpStatus.NO_CONTENT) {
		recruitmentPostService.deleteComment(id)
	}
}