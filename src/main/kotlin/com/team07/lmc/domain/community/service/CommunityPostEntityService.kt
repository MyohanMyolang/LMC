package com.team07.lmc.domain.community.service

import com.team07.lmc.common.domain.member.auth.IAuth
import com.team07.lmc.domain.community.dto.CommunityPostResponse
import com.team07.lmc.domain.community.dto.CommunityPostRequest
import com.team07.lmc.domain.community.entity.CommunityPostEntity
import com.team07.lmc.domain.community.repository.CommunityPostEntityRepository
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CommunityPostEntityService (
    private val communityRepository: CommunityPostEntityRepository,
    private val auth: IAuth
){
    //컴파일 에러 -> Null 예외 처리 해주기 -> EntityNotFoundException

    fun getCommunityPost(postId: Long): CommunityPostResponse {
        val communityPostEntity = communityRepository.findByIdOrNull(postId)?: throw EntityNotFoundException("Entity with ID $postId not found.")
        return communityPostEntity.toResponse()
    }

    fun getCommunityPostList(): List<CommunityPostResponse> {
        return communityRepository.findAll().map { it.toResponse() }
    }

    @Transactional
    fun createCommunityPost(request: CommunityPostRequest): CommunityPostResponse {
        return communityRepository.save(
            CommunityPostEntity(
                title=request.title,
                content = request.content,
                memberEntity = auth.getCurrentMemberEntity()
            )
        ).toResponse()
    }

    @Transactional
    fun updateCommunityPost(postId: Long, request: CommunityPostRequest): CommunityPostResponse {

        val communityPostEntity = communityRepository.findByIdOrNull(postId)?: throw EntityNotFoundException("Entity with ID $postId not found.")
        return auth.checkPermission(communityPostEntity.memberEntity){
            communityPostEntity.title = request.title
            communityPostEntity.content = request.content
            communityRepository.save(communityPostEntity).toResponse()
        }
    }

    @Transactional
    fun deleteCommunityPost(postId: Long) {
        val communityPostEntity = communityRepository.findByIdOrNull(postId)?: throw EntityNotFoundException("Entity with ID $postId not found.")
        auth.checkPermission(communityPostEntity.memberEntity){
            communityRepository.delete(communityPostEntity)
        }
    }
}