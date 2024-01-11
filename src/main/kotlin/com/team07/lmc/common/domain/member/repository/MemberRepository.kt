package com.team07.lmc.common.domain.member.repository

import com.team07.lmc.common.domain.member.entity.MemberEntity
import org.springframework.data.repository.findByIdOrNull

class MemberRepository(
	private val memberEntityRepository: MemberEntityRepository
): IMemberRepository {

	fun findById(id:String) = memberEntityRepository.findByIdOrNull(id) ?: TODO("찾지 못함")

	fun save(entity: MemberEntity) = memberEntityRepository.save(entity)

	fun findByKey(key: String) = memberEntityRepository.findByKey(key)
}