package com.team07.lmc.api.recruit.controller

import com.team07.lmc.api.recruit.service.ParticipantProcessingService
import com.team07.lmc.api.recruit.service.RecruitPostProcessingService
import com.team07.lmc.domain.recruit.dto.CreateRecruitmentPostRequest
import com.team07.lmc.domain.recruit.dto.RecruitmentPostResponse
import com.team07.lmc.domain.recruit.dto.TeamParticipationResponse
import com.team07.lmc.domain.recruit.dto.UpdateRecruitmentPostRequest
import com.team07.lmc.domain.recruit.entity.TeamParticipationEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/recruitment/post")
class RecruitPostController(
    private val recruitmentPostService: RecruitPostProcessingService,


) {

    // 모집글 리스트 형태로 조회
    @GetMapping
    fun getAllRecruitmentPosts(): ResponseEntity<List<RecruitmentPostResponse>> {

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(recruitmentPostService.getAllRecruitmentPosts())
    }

    // 모집글 상세보기
    @GetMapping("/{postId}")
    fun getRecruitmentPostById(@PathVariable postId: Long): ResponseEntity<RecruitmentPostResponse>{

        return ResponseEntity
            .status(HttpStatus.OK)

            .body(recruitmentPostService.getRecruitmentPostById(postId))
    }

    // 모집글 작성
    @PostMapping
    fun createRecruitmentPost(
        @RequestBody createRecruitmentPostRequest: CreateRecruitmentPostRequest
    ): ResponseEntity<RecruitmentPostResponse>{
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(recruitmentPostService.createRecruitmentPost(createRecruitmentPostRequest))
    }

    // 모집글 수정
    @PutMapping("/{postId}")
    fun updateRecruitmentPost(
        @PathVariable postId: Long,
        @RequestBody updateRecruitmentPostRequest: UpdateRecruitmentPostRequest
    ): ResponseEntity<RecruitmentPostResponse>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(recruitmentPostService.updateRecruitmentPost(postId, updateRecruitmentPostRequest))

    }

    // 모집글 삭제
    @DeleteMapping("/{postId}")
    fun deleteRecruitmentPost(@PathVariable postId: Long): ResponseEntity<Unit>{
        recruitmentPostService.deleteRecruitmentPost(postId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

    // 팀원 합류 요청




}