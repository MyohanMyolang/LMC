package com.team07.lmc.api.post.controller

import com.team07.lmc.common.type.PostType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/comment")
class CommentController {

    @GetMapping("/{postType}/{postId}")
    fun getPostCommentList(
        @PathVariable postType: PostType,
        @PathVariable postId: Long
    ) {

    }

    /**
     * TODO: Comment 등록
     *  PostType과 DTO를 받아서 처리
     *  등록된 포스트 정보를 반환한다.
     */

    /**
     * TODO: Comment 수정
     *  UpdateDto를 받는다.
     *  DTO에는 PostType, CommentId, Password가 담겨져 있다.
     *  수정된 정보를 반환한다.
     */

    /**
     * TODO: Comment 삭제
     *  DTO에 CommentId, PostId와 Password를 받는다.
     *  삭제된 정보를 반환한다.
     */
}