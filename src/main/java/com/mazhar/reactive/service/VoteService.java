/**
 *
 */
package com.mazhar.reactive.service;


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
       /* BlogUser user = userRepository.findById(voterID).orElseThrow(() -> new ResourceNotFound("No user found"));
        BlogPost post = postRepository.findById(postID).orElseThrow(() -> new ResourceNotFound("No post found"));
        Vote vote = repository.getVoteOfUser(postID, voterID);
        if (vote == null) {
            Vote v = new Vote();
            v.setPost(post);
            v.setVoter(user);
            v.setVote(true);
            repository.save(v);
        } else {
            vote.setVote(!vote.isVote());
            repository.save(vote);
        }
*/
        return Mono.just(true);

    }

}
