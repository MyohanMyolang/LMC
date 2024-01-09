package com.team07.lmc.domain.recruit.entity

import jakarta.persistence.*

@Entity
@Table(name = "recruit_post_detail")
class RecruitPostDetailEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruit_post_detail_id")
    val id: Long? = null,

    @Column(name = "content")
    val content: String,

    @Column(name = "max_applicants")
    val maxApplicants: Long,

    @Column(name = "num_applicants")
    val numApplicants: Long,

    @Column(name = "consent_status")
    val consentStatus: Boolean
) {}