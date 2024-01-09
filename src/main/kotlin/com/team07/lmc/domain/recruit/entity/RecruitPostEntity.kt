package com.team07.lmc.domain.recruit.entity

import com.team07.lmc.domain.community.entity.CommunityPostDetailEntity
import com.team07.lmc.domain.recruit.dto.RecruitmentPostResponse
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Entity
@Table(name = "recruit_post")
class RecruitPostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,


    @Column(name = "title")
    val title: String,

    @Column(name = "writer")
    val writer: String,

    @CreatedDate
    val createAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "content")
    val content: String,

    @Column(name = "max_applicants")
    val maxApplicants: Long,

    @Column(name = "num_applicants")
    val numApplicants: Long,

    @Column(name = "consent_status")
    val consentStatus: Boolean
) {
}

fun RecruitPostEntity.toResponseDTO(): RecruitmentPostResponse{
    return RecruitmentPostResponse(
        id = id!!,
        title = title,
        writer = writer,
        date = createAt,
        content = content,
        maxApplicants = maxApplicants,
        numApplicants = numApplicants,
        recruitmentEnd = consentStatus
    )
}