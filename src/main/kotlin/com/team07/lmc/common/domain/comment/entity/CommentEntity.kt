package com.team07.lmc.common.domain.comment.entity

import com.team07.lmc.common.domain.comment.dto.CommentAddRequest
import com.team07.lmc.common.domain.comment.dto.CommentResponse
import com.team07.lmc.domain.community.entity.CommunityPostEntity
import com.team07.lmc.domain.recruit.entity.RecruitPostEntity
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Entity
@Table(name = "Comment")
class CommentEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "writer", nullable = false)
    val writer: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "description", nullable = false)
    val description: String,

    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_post_id")
    val communityPostEntity: CommunityPostEntity? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruit_post_id")
    val recruitPostEntity: RecruitPostEntity? = null
) {

    companion object {
        fun encodePassword(password: String): String{
            TODO("encode string")
        }

        fun of(recruitPostEntity: RecruitPostEntity, dto: CommentAddRequest) = CommentEntity(
            writer = dto.writer,
            password = encodePassword(dto.password),
            description = dto.description,
            recruitPostEntity = recruitPostEntity,
        )

        fun of(communityPostEntity: CommunityPostEntity, dto: CommentAddRequest) = CommentEntity(
            writer = dto.writer,
            password = encodePassword(dto.password),
            description = dto.description,
            communityPostEntity = communityPostEntity,
        )
    }

    fun toResponse() = CommentResponse(
        id = id!!,
        writer = writer,
        description = description,
        date = createdAt
    )
}