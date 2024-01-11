package com.team07.lmc.common.domain.member.entity

import jakarta.persistence.*

@Entity
@Table(name = "member")
class MemberEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name = "member_id")
    val memberId: String,

    @Column(name = "username")
    val username: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "key")
    var key: String
){

}
