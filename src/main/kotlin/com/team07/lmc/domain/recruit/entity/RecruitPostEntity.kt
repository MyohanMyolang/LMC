package com.team07.lmc.domain.recruit.entity

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
    val title: String,

    @Column(name = "writer")
    val writer: String,

    @CreatedDate
    val createDate: LocalDateTime = LocalDateTime.now()
) {
}