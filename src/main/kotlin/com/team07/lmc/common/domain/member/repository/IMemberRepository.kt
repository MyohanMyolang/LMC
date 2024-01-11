package com.team07.lmc.common.domain.member.repository

import com.team07.lmc.common.domain.member.entity.MemberEntity

interface IMemberRepository {
	fun findById(id: String): MemberEntity
	fun findByNickname(nickname: String): MemberEntity
	fun save(entity: MemberEntity): MemberEntity
	fun findByKey(key: String): MemberEntity?
}