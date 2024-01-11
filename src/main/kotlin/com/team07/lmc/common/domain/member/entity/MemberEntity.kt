package com.team07.lmc.common.domain.member.entity

import com.team07.lmc.common.domain.member.auth.dto.SignDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.apache.logging.log4j.util.Base64Util

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

	@Column(name = "nickname", nullable = false, unique = true)
	var nickname: String
) {
	companion object{
		private fun encodeString(str: String):String = Base64Util.encode(str)

		private fun of(dto: SignDto, key: String) = MemberEntity(
			memberId = dto.id!!,
			password = encodeString(dto.password!!),
			nickname = dto.nickname!!,
			key = key
		)
	}

	fun isSamePassword(password: String) = this.password == encodeString(password)
}