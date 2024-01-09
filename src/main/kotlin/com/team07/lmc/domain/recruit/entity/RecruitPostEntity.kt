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
    @Column(name = "recruit_post_id")
    val id: Long? = null,


    @Column(name = "title")
    var title: String,

    @Column(name = "writer")
    var writer: String,

    @CreatedDate
    var createAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "content")
    var content: String,

    @Column(name = "max_applicants")
    var maxApplicants: Long,

    @Column(name = "num_applicants")
    var numApplicants: Long,

    @Column(name = "consent_status")
    var consentStatus: Boolean
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