/**
 * 
 */
package com.mazhar.reactive.repository;


import com.mazhar.reactive.model.Vote;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author mazhar
 *
 */
public interface VoteRepository extends ReactiveCrudRepository<Vote, UUID> {
	
	@Query(value = "SELECT COUNT(*) FROM vote WHERE post_id =:post_id AND vote=true")
	Mono<Long> getVotesOfPost(@Param("post_id") UUID postId);
	
	@Query(value = "SELECT * FROM vote WHERE voter_id =:voter_id AND post_id=:post_id")
	 Mono<Vote> getVoteOfUser(@Param("post_id") UUID post,@Param("voter_id") UUID voter);

	@Query(value = "UPDATE vote  SET vote = :vote  WHERE voter_id = :voter_id AND post_id = :post_id")
	Mono<Boolean> updateVote(@Param("vote") boolean vote,@Param("voter_id") UUID voterId, @Param("post_id") UUID postId);


	@Query(value = "SELECT * FROM vote WHERE post_id =:post_id AND vote=true")
	Flux<Vote> getVotesByPost(@Param("post_id") UUID postId);

}
