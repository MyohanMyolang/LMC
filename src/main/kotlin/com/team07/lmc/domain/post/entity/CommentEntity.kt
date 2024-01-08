package com.team07.lmc.domain.post.entity

import jakarta.persistence.*


/**
 * NOTE:
 *  1. Comment Table의 경우 여러 Post의 Comment를 전부 한 곳에서 처리하고 있기 때문에 수가 엄청날 것이다.
 *  2. 그렇기에 그 많은양을 sequence의 숫자로 다 처리하지 못할 경우를 대비해 UUID로 전환한다.
 *  3. 또한 여러 PostType과 그에 해당하는 Post_id를 가지고 있기에 스켄 시간이 걸리므로 Type과 Post_id에 Index를 걸어 탐색 속도를 개선한다.
 */

@Entity
@Table(name = "Comment")
class CommentEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    val id: Long? = null,
){
    /**
     * NOTE: ManyToOne으로
     */
}