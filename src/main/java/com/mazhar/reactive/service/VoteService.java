/**
 *
 */
package com.mazhar.reactive.service;


import com.mazhar.reactive.model.Vote;
import com.mazhar.reactive.repository.PostRepository;
import com.mazhar.reactive.repository.UserRespository;
import com.mazhar.reactive.repository.VoteRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author mazhar
 *
 */
@Service
public class VoteService {

    private UserRespository userRepository;
    private VoteRepository repository;
    private PostRepository postRepository;

    public VoteService(UserRespository userRepository, VoteRepository repository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.repository = repository;
        this.postRepository = postRepository;
    }

    public Mono<Boolean> isLikedByCurrentUser(UUID postId, UUID currentUser) {
        return repository.getVotesByPost(postId).any(e -> e.getVoterId().equals(currentUser));
    }

    public Mono<Long> totalNumberOfVoteOfPost(UUID postId) {
        return repository.getVotesOfPost(postId);
    }

    public Mono<Boolean> voteAPost(UUID postID, UUID voterID)  {
       return repository.getVoteOfUser(postID, voterID).switchIfEmpty(saveVote(postID,voterID)).flatMap(e -> {
           e.setVote(!e.isVote());
           return repository.save(e).then(Mono.just(true));
       });

    }
    private Mono<Vote> saveVote(UUID postId, UUID voterId) {
        Vote v = new Vote();
        v.setPostId(postId);
        v.setVoterId(voterId);
        v.setVote(true);
        return repository.save(v);
    }

}
