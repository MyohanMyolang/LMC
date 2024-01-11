package com.team07.lmc.api.community.controller

import com.team07.lmc.api.community.service.CommunityPostService
import com.team07.lmc.domain.community.dto.CommunityPostResponse
import com.team07.lmc.domain.community.dto.CreateCommunityPostRequest
import com.team07.lmc.domain.community.dto.UpdateCommunityPostRequest
import com.team07.lmc.domain.community.entity.CommunityPostEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/community")
class CommunityPostController (
    private val communityPostService: CommunityPostService
){
    @PostMapping("/posts")
    fun createCommunityPost(@RequestBody createCommunityPostRequest: CreateCommunityPostRequest): ResponseEntity<CommunityPostResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(communityPostService.createCommunityPost(createCommunityPostRequest))
    }

    @GetMapping("/posts/{postId}")
    fun getCommunityPost(@PathVariable postId: Long): ResponseEntity<CommunityPostResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(communityPostService.getCommunityPost(postId))
    }

    @GetMapping("/posts")
    fun getCommunityPostList(): ResponseEntity<List<CommunityPostResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(communityPostService.getCommunityPostList())
    }

    @PutMapping("/posts/{postId}")
    fun updateCommunityPost(
        @PathVariable postId: Long,
        @RequestBody updateCommunityPostRequest: UpdateCommunityPostRequest
    ): ResponseEntity<CommunityPostResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(communityPostService.updateCommunityPost(postId, updateCommunityPostRequest))
    }

    @DeleteMapping("/posts/{postId}")
    fun deleteCommunityPost(@PathVariable postId: Long): ResponseEntity<Unit> {
        communityPostService.deleteCommunityPost(postId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }


}