package com.team07.lmc.api.recruit.service

import com.team07.lmc.domain.recruit.dto.CreateRecruitmentPostRequest
import com.team07.lmc.domain.recruit.dto.RecruitmentPostResponse
import com.team07.lmc.domain.recruit.dto.UpdateRecruitmentPostRequest
import com.team07.lmc.domain.recruit.service.RecruitPostService
import org.springframework.transaction.annotation.Transactional

class RecruitPostProcessingService(
    private val recruitPostService: RecruitPostService
) {

    fun getAllRecruitmentPosts(): List<RecruitmentPostResponse>{
        return recruitPostService.getAllRecruitmentPosts()
    }


    fun getRecruitmentPostById(postId: Long): RecruitmentPostResponse {
        return recruitPostService.getRecruitmentPostById(postId)

    }


    fun createRecruitmentPost(createRecruitmentPostRequest: CreateRecruitmentPostRequest): RecruitmentPostResponse {
        return recruitPostService.createRecruitmentPost(createRecruitmentPostRequest)
    }

    fun updateRecruitmentPost(postId: Long, updateRecruitmentPostRequest: UpdateRecruitmentPostRequest): RecruitmentPostResponse {
        return recruitPostService.updateRecruitmentPost(postId, updateRecruitmentPostRequest)

    }
}