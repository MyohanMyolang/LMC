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
        TODO("Not yet implemented")
    }

    fun getCommunityPost(postId: Long): CommunityPostResponse {
        TODO("Not yet implemented")
    }

    fun getCommunityPostList(): List<CommunityPostResponse> {
        TODO("Not yet implemented")
    }

    fun updateCommunityPost(
        postId: Long,
        updateCommunityPostRequest: UpdateCommunityPostRequest
    ): CommunityPostResponse {
        TODO("Not yet implemented")
    }

    fun deleteCommunityPost(postId: Long) {
        TODO("Not yet implemented")
    }
}