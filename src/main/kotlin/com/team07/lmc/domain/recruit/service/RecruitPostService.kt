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
    fun getAllRecruitmentPosts(): List<RecruitmentPostResponse> =
        recruitPostRepository.findAll().map { it.toResponseDTO() }


    fun getRecruitmentPostById(postId: Long): RecruitmentPostResponse {
        val recruitmentPost = recruitPostRepository.findByIdOrNull(postId)
            ?: throw IllegalStateException()
        return recruitmentPost.toResponseDTO()
    }

    @Transactional
    fun createRecruitmentPost(request: CreateRecruitmentPostRequest): RecruitmentPostResponse {
        return recruitPostRepository.save(
            RecruitPostEntity(
                title = request.title,
                writer = request.writer,
                content = request.content,
                maxApplicants = request.maxApplicants,
                numApplicants = request.numApplicants,
                consentStatus = false
            )
        ).toResponseDTO()
    }

    @Transactional
    fun updateRecruitmentPost(postId: Long, request: UpdateRecruitmentPostRequest): RecruitmentPostResponse {
        val recruitmentPost = recruitPostRepository.findByIdOrNull(postId)  ?: TODO("예외처리 필요")
        val (title, content, maxApplicants, numApplicants, recruitmentEnd) = request
        recruitmentPost.title = title
        recruitmentPost.content = content
        recruitmentPost.maxApplicants = maxApplicants
        recruitmentPost.numApplicants = numApplicants
        recruitmentPost.consentStatus = recruitmentEnd

        return recruitPostRepository.save(recruitmentPost).toResponseDTO()
    }

    @Transactional
    fun deleteRecruitmentPost(postId: Long) {
        val recruitmentPost = recruitPostRepository.findByIdOrNull(postId) ?: TODO("예외처리 필요")
        recruitPostRepository.delete(recruitmentPost)
    }


}