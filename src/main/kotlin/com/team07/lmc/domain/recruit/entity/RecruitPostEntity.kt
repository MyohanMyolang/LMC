package com.team07.lmc.domain.recruit.entity

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
    val createdAt: LocalDateTime = LocalDateTime.now(),


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