package com.team07.lmc.domain.repository

import org.springframework.stereotype.Repository

@Repository
class CommentRepository(
    private val commentEntityRepository: CommentEntityRepository
): ICommentRepository {

    /**
     * NOTE : 댓글 리스트를 탐색할 때
     *  1. UUID와
     */
}