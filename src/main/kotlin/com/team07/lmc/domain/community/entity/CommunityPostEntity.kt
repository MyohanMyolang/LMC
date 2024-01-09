package com.team07.lmc.domain.community.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Entity
@Table(name = "Post")
class CommunityPostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_post_id")
    val id: Long? = null,

    @Column(name = "title")
    val title: String,

    @Column(name = "content")
    val content: String,

    @Column(name = "writer")
    val writer: String,

    @CreatedDate
    @Column(name = "create_date")
    val createDate: LocalDateTime = LocalDateTime.now()
) {

}