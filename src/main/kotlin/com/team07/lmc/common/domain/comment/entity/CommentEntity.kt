package com.team07.lmc.common.domain.comment.entity

import com.team07.lmc.common.domain.comment.dto.CommentAddRequest
import com.team07.lmc.common.domain.comment.dto.CommentResponse
import com.team07.lmc.common.domain.comment.type.PostType
import com.team07.lmc.common.domain.member.entity.MemberEntity
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Entity
@Table(name = "Comment")
class CommentEntity(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long? = null,

	@Column(name = "member_nickname")
	val memberNickname: String,

	@Column(name = "description")
	var description: String,

	@CreatedDate
	val createdAt: LocalDateTime = LocalDateTime.now(),

	@Enumerated(value = EnumType.STRING)
	private val postType: PostType,

	private val postId: Long,
) {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_nickname", referencedColumnName = "nickname", insertable = false, updatable = false)
	val member: MemberEntity? = null

	companion object {
		fun of(postType: PostType, postId: Long, memberNickname: String, dto: CommentAddRequest) = CommentEntity(
			memberNickname = memberNickname,
			description = dto.description,
			postType = postType,
			postId = postId
		)
	}

	fun toResponse() = CommentResponse(
		id = id!!,
		writer = memberNickname,
		description = description,
		date = createdAt
	)
}