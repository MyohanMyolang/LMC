package com.team07.lmc.api.auth.service

import com.team07.lmc.common.domain.member.auth.IAuth
import com.team07.lmc.common.domain.member.auth.dto.SignDto
import com.team07.lmc.common.domain.member.entity.MemberEntity
import com.team07.lmc.common.domain.member.service.MemberService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AuthService(
	private val memberService: MemberService,
	private val auth: IAuth
) {

	@Transactional
	fun signUp(signDto: SignDto): Boolean = with(signDto) {
		memberService.signUp(signDto)
		true
	}

	fun signIn(signDto: SignDto): String =
		memberService.findByMemberId(signDto.id!!)
			.let {
				if (!it.isSamePassword(signDto.password!!))
					TODO("비밀번호가 틀립니다.")
				else
					"${auth.getType()} ${it.key}"
			}

}
