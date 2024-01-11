package com.team07.lmc.domain.recruit.service

import com.team07.lmc.domain.recruit.dto.CreateRecruitmentPostRequest
import com.team07.lmc.domain.recruit.dto.RecruitmentPostResponse
import com.team07.lmc.domain.recruit.dto.UpdateRecruitmentPostRequest
import com.team07.lmc.domain.recruit.entity.RecruitPostEntity
import com.team07.lmc.domain.recruit.entity.toResponseDTO
import com.team07.lmc.domain.recruit.repository.RecruitPostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RecruitPostService(
    private val recruitPostRepository: RecruitPostRepository
) {
    fun getAllRecruitmentPosts(): List<RecruitmentPostResponse> {
        return recruitPostRepository.findAll().map { it.toResponseDTO() }
    }

    fun getRecruitmentPostById(postId: Long): RecruitmentPostResponse {
        val recruitmentPost = recruitPostRepository.findByIdOrNull(postId)
            ?: throw IllegalStateException()
        return recruitmentPost.toResponseDTO()
    }

//    @Transactional
    fun createRecruitmentPost(request: CreateRecruitmentPostRequest): RecruitmentPostResponse {
        return recruitPostRepository.save(
            RecruitPostEntity(
                title = request.title,
                writer = request.writer,
                content = request.content,
                createAt = request.date,
                maxApplicants = request.maxApplicants,
                numApplicants = request.numApplicants,
                consentStatus = false
            )
        ).toResponseDTO()

    }

    fun updateRecruitmentPost(postId: Long, Request: UpdateRecruitmentPostRequest): RecruitmentPostResponse {
        val recruitmentPost = recruitPostRepository.findByIdOrNull(postId)  // TODO:예외처리 필요
        val ()

    }
}