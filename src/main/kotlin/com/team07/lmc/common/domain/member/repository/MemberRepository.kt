package com.team07.lmc.common.domain.member.repository

import com.team07.lmc.common.domain.member.entity.MemberEntity
import com.team07.lmc.global.exceptions.NotFoundTargetException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class MemberRepository(
	private val memberEntityRepository: MemberEntityRepository
) : IMemberRepository {

	override fun findByNickname(nickname: String) =
		memberEntityRepository.findByNickname(nickname) ?: throw NotFoundTargetException("유저 찾지 못함")

	override fun findById(id: String) =
		memberEntityRepository.findByIdOrNull(id) ?: throw NotFoundTargetException("유저 찾지 못함")

	override fun save(entity: MemberEntity) = memberEntityRepository.save(entity)

	override fun findByKey(key: String) = memberEntityRepository.findByKey(key)

	override fun duplicateCheck(id: String, nickname: String) =
		memberEntityRepository.findByMemberIdOrNickname(id, nickname)
}