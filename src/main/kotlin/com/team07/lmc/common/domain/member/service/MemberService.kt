package com.team07.lmc.common.domain.member.service

import com.team07.lmc.common.domain.member.entity.MemberEntity
import com.team07.lmc.common.domain.member.repository.IMemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
	private val memberRepository: IMemberRepository
) {
	fun findByMemberId(id: String): MemberEntity = memberRepository.findById(id)

	fun signUp(entity: MemberEntity) = memberRepository.save(entity)

}
