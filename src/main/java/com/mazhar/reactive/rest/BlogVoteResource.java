/**
 * 
 */
package com.mazhar.reactive.rest;


import com.mazhar.reactive.service.VoteService;
import com.mazhar.reactive.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	ResponseEntity<?> isLikedByCurrentUser(@PathVariable(name = "post_id") UUID postId,@RequestParam(name="user" , required = false) UUID currentUser ) {
		boolean vote = service.isLikedByCurrentUser(postId, currentUser);
		return new ResponseEntity<Object>(vote, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{post_id}")
	ResponseEntity<?> getVoteCounts(@PathVariable(name = "post_id") UUID postId) {
		try {
			int vote = service.totalNumberOfVoteOfPost(postId);
			return new ResponseEntity<Object>(vote, new HttpHeaders(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>(AppResponse.operationFail(e.getMessage()), new HttpHeaders(),
					HttpStatus.OK);
		}

	}

	@PutMapping("/{post_id}")
	ResponseEntity<?> updateVote(@PathVariable(name = "post_id") UUID postId,
								 @RequestParam(name="user") UUID voterId) {
		try {
			return new ResponseEntity<Object>(service.voteAPost(postId, voterId), new HttpHeaders(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>(AppResponse.operationFail(e.getMessage()), new HttpHeaders(),
					HttpStatus.OK);
		}

	}
}
