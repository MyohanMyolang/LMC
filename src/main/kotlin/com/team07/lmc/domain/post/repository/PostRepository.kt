package com.team07.lmc.domain.post.repository

import org.springframework.stereotype.Repository

@Repository
class PostRepository(
    private val commentEntityRepository: CommentEntityRepository
): IPostRepository {

    /**
     * NOTE : 댓글 리스트를 탐색할 때
     *  1. UUID와
     */
}