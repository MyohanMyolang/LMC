package com.team07.lmc.domain.community.repository

import com.team07.lmc.common.domain.comment.repository.CommentEntityRepository
import org.springframework.stereotype.Repository

@Repository
class CommunityRepository(
    private val commentEntityRepository: CommentEntityRepository
): ICommunityRepository {

}