/**
 * 
 */
package com.mazhar.reactive.rest;


import com.mazhar.reactive.model.Comment;
import com.mazhar.reactive.model.dto.CommentDTO;
import com.mazhar.reactive.service.CommentService;
import com.mazhar.reactive.util.AppResponse;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static com.mazhar.reactive.util.AppConstant.ROOT_PATH;

/**
 * @author mazhar
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path = ROOT_PATH + "comments", produces = { "application/json" })
public class BlogCommentResource {
	private Logger log = LoggerFactory.getLogger(BlogCommentResource.class);
	private CommentService service;

	@Autowired
	public void setCommentService(CommentService service) {
		this.service = service;
	}
	
	@GetMapping("/{post}")
	Publisher<?> getCommentsOfPost(@PathVariable(name = "post") UUID postId) {
		return service.getAllComments(postId);
	}
	 
	@PostMapping("/{post}")
	Publisher<?> makeAComment(@PathVariable(name = "post") UUID postId, @RequestBody CommentDTO comment) {
		try {
			service.commentAPost(comment, postId);
			return Mono.just(AppResponse.resourceCreated());
		} catch (Exception e) {
			log.error(e.getMessage());
			return Mono.just(AppResponse.operationFail(e.getMessage()));
		}
	}
}
