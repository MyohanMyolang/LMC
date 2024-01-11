package com.team07.lmc.common.domain.comment.repository

import com.team07.lmc.common.domain.comment.entity.CommentEntity
import com.team07.lmc.common.domain.comment.type.PostType
import com.team07.lmc.domain.community.entity.CommunityPostEntity
import com.team07.lmc.domain.recruit.entity.RecruitPostEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CommentEntityRepository : JpaRepository<CommentEntity, Long> {
    fun getCommentEntitiesByPostTypeAndPostId(postType: PostType, postId: Long): List<CommentEntity>
}