package com.team07.lmc.domain.community.repository

import com.team07.lmc.common.domain.comment.repository.CommentEntityRepository
import org.springframework.stereotype.Repository

@Repository
class CommunityRepository(
    private val commentEntityRepository: CommentEntityRepository
): ICommunityRepository {

    /**
     * NOTE : 댓글 리스트를 탐색할 때
     *  1. UUID와
     */
}