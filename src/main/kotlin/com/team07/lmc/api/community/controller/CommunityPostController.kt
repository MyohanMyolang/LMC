package com.team07.lmc.api.community.controller


import com.team07.lmc.api.community.service.CommunityPostService
import com.team07.lmc.api.util.responseEntity
import com.team07.lmc.common.domain.comment.dto.CommentAddRequest
import com.team07.lmc.common.domain.comment.dto.UpdateCommentRequest
import com.team07.lmc.domain.community.dto.CommunityPostRequest
import com.team07.lmc.domain.community.dto.CommunityPostResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/community")
class CommunityPostController(
	private val communityPostService: CommunityPostService
) {
	@PostMapping("/post")
	fun createCommunityPost(@RequestBody communityPostRequest: CommunityPostRequest): ResponseEntity<CommunityPostResponse> {
		return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(communityPostService.createCommunityPost(communityPostRequest))
	}

	@GetMapping("/post/{postId}")
	fun getCommunityPost(@PathVariable postId: Long) =
		ResponseEntity
			.status(HttpStatus.OK)
			.body(communityPostService.getCommunityPost(postId))


	@GetMapping("/posts")
	fun getCommunityPostList(): ResponseEntity<List<CommunityPostResponse>> {
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(communityPostService.getCommunityPostList())
	}

	@PutMapping("/post/{postId}")
	fun updateCommunityPost(
		@PathVariable postId: Long,
		@RequestBody updateCommunityPostRequest: CommunityPostRequest
	): ResponseEntity<CommunityPostResponse> {
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(communityPostService.updateCommunityPost(postId, updateCommunityPostRequest))
	}

	@DeleteMapping("/post/{postId}")
	fun deleteCommunityPost(@PathVariable postId: Long): ResponseEntity<Unit> {
		communityPostService.deleteCommunityPost(postId)
		return ResponseEntity
			.status(HttpStatus.NO_CONTENT)
			.build()
	}

	@PostMapping("/post/{postId}/comment")
	fun addComment(
		@PathVariable postId: Long,
		@RequestBody commentAddRequest: CommentAddRequest
	) = responseEntity(HttpStatus.CREATED) {
		communityPostService.addComment(postId, commentAddRequest)
	}

	@PatchMapping("/post/comment/{id}")
	fun patchComment(
		@PathVariable id: Long,
		@RequestBody updateCommentRequest: UpdateCommentRequest
	) = responseEntity(HttpStatus.OK) {
		communityPostService.patchComment(id, updateCommentRequest)
	}

	@DeleteMapping("/post/comment/{id}")
	fun deleteComment(@PathVariable id: Long) = responseEntity(HttpStatus.NO_CONTENT) {
		communityPostService.deleteComment(id)
	}

}