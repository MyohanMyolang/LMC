package com.team07.lmc.domain.recruit.entity

import com.team07.lmc.common.domain.comment.type.PostType
import com.team07.lmc.common.domain.member.entity.MemberEntity
import com.team07.lmc.domain.recruit.dto.RecruitmentPostResponse
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Entity
@Table(name = "recruit_post")
class RecruitPostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,


    @Column(name = "teamName")
    var teamName: String,

    @CreatedDate
    var createAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "content")
    var content: String,

    @Column(name = "max_applicants")
    var maxApplicants: Long,

    @Column(name = "num_applicants")
    var numApplicants: Long = 0,

    @Column(name = "approval_status")
    var approvalStatus: Boolean,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id", nullable = false)
    var memberEntity: MemberEntity
) {
    @Enumerated(value = EnumType.STRING)
    private val postType: PostType = PostType.RECRUIT

    fun isClosed(): Boolean{
        return !approvalStatus
    }

    fun addApplicants(){
        numApplicants += 1
    }

    fun isFull(): Boolean{
        return maxApplicants == numApplicants
    }

    fun close(){
        approvalStatus = false
    }
}

fun RecruitPostEntity.toResponseDTO(): RecruitmentPostResponse{
    return RecruitmentPostResponse(
        id = id!!,
        teamName = teamName,
        date = createAt,
        content = content,
        maxApplicants = maxApplicants,
        numApplicants = numApplicants,
        recruitmentEnd = approvalStatus
    )
}