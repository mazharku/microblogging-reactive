/**
 *
 */
package com.mazhar.reactive.service;


import com.mazhar.reactive.exception.ResourceNotFound;
import com.mazhar.reactive.model.BlogPost;
import com.mazhar.reactive.model.BlogUser;
import com.mazhar.reactive.model.Vote;
import com.mazhar.reactive.repository.PostRepository;
import com.mazhar.reactive.repository.UserRespository;
import com.mazhar.reactive.repository.VoteRepository;
import org.springframework.stereotype.Service;

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

    public boolean isLikedByCurrentUser(UUID postId, UUID currentUser) {
       return false;
        // return repository.getVotesByPost(postId).stream().anyMatch(e -> e.getVoter().getId().equals(currentUser));
    }

    public int totalNumberOfVoteOfPost(UUID postId) {
        return 0;
    }

    public boolean voteAPost(UUID postID, UUID voterID) throws ResourceNotFound {
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
        return true;

    }

}
