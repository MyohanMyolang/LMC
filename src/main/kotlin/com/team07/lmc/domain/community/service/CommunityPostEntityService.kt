package com.team07.lmc.domain.community.service

import com.team07.lmc.domain.community.dto.CommunityPostResponse
import com.team07.lmc.domain.community.dto.CreateCommunityPostRequest
import com.team07.lmc.domain.community.dto.UpdateCommunityPostRequest
import com.team07.lmc.domain.community.entity.CommunityPostEntity
import com.team07.lmc.domain.community.repository.ICommunityRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CommunityPostEntityService (
    private val communityRepository: ICommunityRepository
){
    //컴파일 에러 -> Null 예외 처리 해주기 -> EntityNotFoundException

    fun getCommunityPost(postId: Long): CommunityPostResponse {
        val communutyPostEntity = communityRepository.findByIdOrNull(postId)?: throw EntityNotFoundException("Entity with ID $postId not found.")
        return communutyPostEntity.toResponse()
    }

    fun getCommunityPostList(): List<CommunityPostResponse> {
        return communityRepository.findAll().map { it.toResponse() }
    }

    fun createCommunityPost(request: CreateCommunityPostRequest): CommunityPostResponse {
        return communityRepository.save(
            CommunityPostEntity(
                title=request.title,
                content = request.content
            )
        ).toResponse()
    }

    fun updateCommunityPost(postId: Long, request: UpdateCommunityPostRequest): CommunityPostResponse {
        val communutyPostEntity = communityRepository.findByIdOrNull(postId)?: throw EntityNotFoundException("Entity with ID $postId not found.")

        communutyPostEntity.title = request.title
        communutyPostEntity.content = request.content

        return communityRepository.save(communutyPostEntity).toResponse()
    }

    fun deleteCommunityPost(postId: Long) {
        val communutyPostEntity = communityRepository.findByIdOrNull(postId)?: throw EntityNotFoundException("Entity with ID $postId not found.")
        communityRepository.delete(communutyPostEntity)
    }

}