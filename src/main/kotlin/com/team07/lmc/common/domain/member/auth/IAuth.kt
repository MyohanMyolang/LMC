package com.team07.lmc.common.domain.member.auth

import com.team07.lmc.common.domain.member.auth.dto.SignDto
import com.team07.lmc.common.domain.member.entity.MemberEntity


interface IAuth {
	fun generateKey(signDto: SignDto): String
	fun getCurrentMemberEntity(): MemberEntity
	fun getType(): String
	fun <T> checkPermission(member: MemberEntity, func: () -> T): T
}