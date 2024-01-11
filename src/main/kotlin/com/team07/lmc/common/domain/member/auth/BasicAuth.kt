package com.team07.lmc.common.domain.member.auth

import com.team07.lmc.common.domain.member.auth.dto.SignDto
import com.team07.lmc.common.domain.member.entity.MemberEntity
import com.team07.lmc.common.domain.member.repository.MemberEntityRepository
import jakarta.servlet.http.HttpServletRequest
import org.apache.logging.log4j.util.Base64Util
import org.springframework.stereotype.Component


@Component
class BasicAuth(
	private val request: HttpServletRequest,
	private val memberEntityRepository: MemberEntityRepository
) : IAuth {

	fun getCurrentMemberKey(): String =
		request.getHeader("Authorization")?.split(" ")?.get(1) ?: TODO("로그인 안되어 있습니다. exception 만들기")


	override fun getCurrentMemberEntity(): MemberEntity =
		getCurrentMemberKey().split(" ")[1].let {
			memberEntityRepository.findByKey(it) ?: TODO("로그인 상태 확인. exception 만들기")
		}

	override fun getType(): String = "basic"

	override fun generateKey(signDto: SignDto): String =
		Base64Util.encode("${signDto.id}:${signDto.password}")

	override fun <T> checkPermission(member: MemberEntity, func: () -> T): T =
		getCurrentMemberKey()
			.let { if (it != member.key) TODO("접근 권한 없음 에러. exception 만들기") }
			.let { func.invoke() }
}