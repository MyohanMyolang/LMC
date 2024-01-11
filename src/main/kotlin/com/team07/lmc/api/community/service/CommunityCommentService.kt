package com.team07.lmc.api.community.service

import com.team07.lmc.common.domain.comment.service.CommentService
import org.springframework.stereotype.Service

@Service
class CommunityCommentService (
    private val commentService: CommentService
){
}