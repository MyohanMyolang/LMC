package com.team07.lmc.domain.recruit.entity

import jakarta.persistence.*


// 임시로 만듦
@Entity
@Table(name = "member")
class MemberEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruit_post_id")
    val id: Long? = null,

    @Column(name = "userName")
    var userName: String

){

}
