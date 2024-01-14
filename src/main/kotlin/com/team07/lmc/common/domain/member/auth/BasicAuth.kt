package com.team07.lmc.common.domain.member.auth

import com.team07.lmc.common.domain.member.auth.dto.SignDto
import com.team07.lmc.common.domain.member.entity.MemberEntity
import com.team07.lmc.common.domain.member.repository.MemberEntityRepository
import com.team07.lmc.global.exceptions.AccessAuthException
import com.team07.lmc.global.exceptions.NotFoundTargetException
import com.team07.lmc.global.exceptions.UnauthorizedException
import jakarta.servlet.http.HttpServletRequest
import org.apache.logging.log4j.util.Base64Util
import org.springframework.stereotype.Component


@Component
class BasicAuth(
	private val request: HttpServletRequest,
	private val memberEntityRepository: MemberEntityRepository
) : IAuth {

	// 현재 사용자의 키 받아옴
	fun getCurrentMemberKey(): String =
		request.getHeader("Authorization")?.split(" ")?.get(1) ?: throw UnauthorizedException("로그인이 되어있지 않습니다.")


	// 현재 사용자의 엔티티 받아옴
	override fun getCurrentMemberEntity(): MemberEntity =
		getCurrentMemberKey().let {
			memberEntityRepository.findByKey(it) ?: throw NotFoundTargetException("로그인 상태를 확인하여 주십시오.")
		}


	override fun getType(): String = "basic"

	// 키 생성
	override fun generateKey(signDto: SignDto): String =
		Base64Util.encode("${signDto.id}:${signDto.password}")

	// 접근권한 확인
	override fun <T> checkPermission(member: MemberEntity, func: () -> T): T =
		getCurrentMemberKey()
			.let { if (it != member.key) throw AccessAuthException("접근 권한이 없습니다.") }
			.let { func.invoke() }
}