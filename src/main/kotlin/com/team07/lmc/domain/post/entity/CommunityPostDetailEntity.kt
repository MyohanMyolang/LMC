package com.team07.lmc.domain.post.entity

import jakarta.persistence.*

@Entity
@Table(name = "community_post_detail")
class CommunityPostDetailEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_post_detail_id")
    val id: Long? = null,

    @Column(name = "content")
    val content: String
) {
}