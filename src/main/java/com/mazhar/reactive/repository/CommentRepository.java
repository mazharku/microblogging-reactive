/**
 * 
 */
package com.mazhar.reactive.repository;


import com.mazhar.reactive.model.Comment;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

/**
 * @author mazhar
 *
 */
public interface CommentRepository extends ReactiveCrudRepository<Comment, UUID> {


	@Query(value = "SELECT * FROM comment WHERE post_id =:post_id")
	public Flux<Comment> getCommentsByPost(@Param("post_id") UUID postId);
}
