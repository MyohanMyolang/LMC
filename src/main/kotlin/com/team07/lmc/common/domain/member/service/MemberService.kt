package com.team07.lmc.common.domain.member.service

import com.team07.lmc.common.domain.member.auth.IAuth
import com.team07.lmc.common.domain.member.auth.dto.SignDto
import com.team07.lmc.common.domain.member.entity.MemberEntity
import com.team07.lmc.common.domain.member.repository.IMemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
	private val memberRepository: IMemberRepository,
	private val auth: IAuth
) {
	fun findByMemberId(id: String): MemberEntity = memberRepository.findById(id)

	fun signUp(dto: SignDto) =
		auth.generateKey(dto)
			.let { MemberEntity.of(dto, it) }
			.let { memberRepository.save(it) }

	fun duplicateCheck(dto: SignDto) =
		memberRepository.duplicateCheck(dto.id!!, dto.nickname!!)
			.let { if(it != null) TODO("중복된 ID 또는 Nickname") }
}
