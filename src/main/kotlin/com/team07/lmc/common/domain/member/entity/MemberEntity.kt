package com.team07.lmc.common.domain.member.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "member")
class MemberEntity(
    @Id
    @Column(name = "member_id", unique = true, nullable = false)
    var memberId: String,

    @Column(name = "password", nullable = false)
    var password: String,

    @Column(name = "key", nullable = false)
    var key: String,

    @Column(name = "nickname", nullable = false)
    var nickname: String
) {
}
