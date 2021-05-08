/**
 * 
 */
package com.mazhar.reactive.rest;


import com.mazhar.reactive.service.VoteService;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.mazhar.reactive.util.AppConstant.ROOT_PATH;

/**
 * @author mazhar
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path = ROOT_PATH + "votes", produces = { "application/json" })
public class BlogVoteResource {
	private Logger log = LoggerFactory.getLogger(BlogVoteResource.class);
	private VoteService service;

	@Autowired
	public void setBlogPostService(VoteService service) {
		this.service = service;
	}

	@PostMapping("/{post_id}")
	Publisher<?> isLikedByCurrentUser(@PathVariable(name = "post_id") UUID postId,@RequestParam(name="user" , required = false) UUID currentUser ) {
	 return service.isLikedByCurrentUser(postId, currentUser);
	}

	@GetMapping("/{post_id}")
	Publisher<?> getVoteCounts(@PathVariable(name = "post_id") UUID postId) {
	  return service.totalNumberOfVoteOfPost(postId);
	}

	@PutMapping("/{post_id}")
	Publisher<?> updateVote(@PathVariable(name = "post_id") UUID postId,
								 @RequestParam(name="user") UUID voterId) {
		return service.voteAPost(postId, voterId);

	}
}
