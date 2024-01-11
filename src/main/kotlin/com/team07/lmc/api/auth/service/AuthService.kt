package com.team07.lmc.api.auth.service

import com.team07.lmc.common.domain.member.auth.dto.SignDto
import com.team07.lmc.common.domain.member.service.MemberService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AuthService(
	private val memberService: MemberService
) {
	fun getMemberByMemberId(memberId: String) =
		memberService.findByMemberId(memberId) ?: TODO("해당 ID는 존재하지 않습니다.")

	@Transactional
	override fun signUp(signDto: SignDto): Boolean {
		if (memberService.findByMemberId(signDto.id!!) != null) TODO("id 중복")
		memberService.signUp(Member.of(signDto, auth.generateKey(signDto)))
		return true
	}

	override fun signIn(signDto: SignDto): String {
		val memberEntity = getMemberByMemberId(signDto.id!!)
		if (!Member.of(signDto, "").isSameIdAndPw(memberEntity)) throw NotFoundTargetException("비밀번호가 틀립니다.")

		return "${auth.getType()} ${memberEntity.key!!}"
	}

}
