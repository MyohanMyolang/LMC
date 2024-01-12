package com.team07.lmc.common.domain.member.repository

import com.team07.lmc.common.domain.member.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberEntityRepository : JpaRepository<MemberEntity, String> {
	fun findByNickname(nickname: String): MemberEntity?
	fun findByKey(key: String): MemberEntity?
	fun findByMemberIdAndNickname(id: String, nickname: String): MemberEntity?
}