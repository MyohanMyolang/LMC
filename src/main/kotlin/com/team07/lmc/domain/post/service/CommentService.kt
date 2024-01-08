package com.team07.lmc.domain.post.service

import com.team07.lmc.common.type.PostType
import com.team07.lmc.domain.post.repository.IPostRepository
import org.springframework.stereotype.Service

@Service
class CommentService (
    private val commentRepository: IPostRepository
){

    /**
     * NOTE:
     *  1.
     */
    fun getCommentListByPostTypeAndPostId(postType: PostType, postId: Long){

    }
}