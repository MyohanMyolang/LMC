package com.team07.lmc.domain.service

import com.team07.lmc.common.type.PostType
import com.team07.lmc.domain.repository.ICommentRepository
import org.springframework.stereotype.Service

@Service
class CommentService (
    private val commentRepository: ICommentRepository
){

    /**
     * NOTE:
     *  1.
     */
    fun getCommentListByPostTypeAndPostId(postType: PostType, postId: Long){

    }
}