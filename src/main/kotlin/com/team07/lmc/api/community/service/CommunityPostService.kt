package com.team07.lmc.api.community.service

import com.team07.lmc.domain.community.dto.CommunityPostResponse
import com.team07.lmc.domain.community.dto.CreateCommunityPostRequest
import com.team07.lmc.domain.community.dto.UpdateCommunityPostRequest
import com.team07.lmc.domain.community.service.CommunityPostEntityService
import org.springframework.stereotype.Service

@Service
class CommunityPostService (
    private val communityPostEntityService: CommunityPostEntityService
){
    fun createCommunityPost(createCommunityPostRequest: CreateCommunityPostRequest): CommunityPostResponse {
        return communityPostEntityService.createCommunityPost(createCommunityPostRequest)
    }

    fun getCommunityPost(postId: Long): CommunityPostResponse {
        return communityPostEntityService.getCommunityPost(postId)
    }

    fun getCommunityPostList(): List<CommunityPostResponse> {
        return communityPostEntityService.getCommunityPostList()
    }

    fun updateCommunityPost(
        postId: Long,
        updateCommunityPostRequest: UpdateCommunityPostRequest
    ): CommunityPostResponse {
        return communityPostEntityService.updateCommunityPost(postId, updateCommunityPostRequest)
    }

    fun deleteCommunityPost(postId: Long) {
        communityPostEntityService.deleteCommunityPost(postId)
    }
}