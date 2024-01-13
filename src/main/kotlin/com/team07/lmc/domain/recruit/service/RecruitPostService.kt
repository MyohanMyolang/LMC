package com.team07.lmc.domain.recruit.service

import com.team07.lmc.common.domain.member.auth.IAuth
import com.team07.lmc.common.domain.member.repository.MemberEntityRepository
import com.team07.lmc.domain.recruit.dto.CreateRecruitmentPostRequest
import com.team07.lmc.domain.recruit.dto.RecruitmentPostResponse
import com.team07.lmc.domain.recruit.dto.UpdateRecruitmentPostRequest
import com.team07.lmc.domain.recruit.entity.RecruitPostEntity
import com.team07.lmc.domain.recruit.repository.RecruitPostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RecruitPostService(
    private val recruitPostRepository: RecruitPostRepository,
    private val memberEntityRepository: MemberEntityRepository,
    private val auth: IAuth
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
        val userEntity = auth.getCurrentMemberEntity()
        return recruitPostRepository.save(
            RecruitPostEntity(
                teamName = request.title,
                content = request.content,
                maxApplicants = request.maxApplicants,
                approvalStatus = true,
                memberEntity = userEntity
            )
        ).toResponseDTO()
    }

    @Transactional
    fun updateRecruitmentPost(postId: Long, request: UpdateRecruitmentPostRequest): RecruitmentPostResponse {
        val recruitmentPost = recruitPostRepository.findByIdOrNull(postId)  ?: TODO("예외처리 필요")
        auth.checkPermission(recruitmentPost.memberEntity){
            val (title, content, maxApplicants, recruitmentEnd) = request
            recruitmentPost.teamName = title
            recruitmentPost.content = content
            recruitmentPost.maxApplicants = maxApplicants
            recruitmentPost.approvalStatus = recruitmentEnd
        }
        return recruitPostRepository.save(recruitmentPost).toResponseDTO()


    }

    @Transactional
    fun deleteRecruitmentPost(postId: Long) {
        val recruitmentPost = recruitPostRepository.findByIdOrNull(postId) ?: TODO("예외처리 필요")
        auth.checkPermission(recruitmentPost.memberEntity) {
            recruitPostRepository.delete(recruitmentPost)
        }
    }


}