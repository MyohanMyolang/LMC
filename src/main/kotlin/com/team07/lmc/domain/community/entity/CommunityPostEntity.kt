package com.team07.lmc.domain.community.entity

import com.team07.lmc.common.domain.comment.type.PostType
import com.team07.lmc.common.domain.member.entity.MemberEntity
import com.team07.lmc.domain.community.dto.CommunityPostResponse
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Entity
@Table(name = "Post")
class CommunityPostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val memberEntity: MemberEntity?=null,

    @Column(name = "title")
    var title: String,

    @Column(name = "content")
    var content: String,

    @CreatedDate
    @Column(name = "create_date")
    val createdAt: LocalDateTime = LocalDateTime.now(),
) {
    @Enumerated(value = EnumType.STRING)
    private val postType: PostType = PostType.COMMUNITY

    fun toResponse(): CommunityPostResponse {
        return CommunityPostResponse(id!!, title, content, createdAt)
    }
}