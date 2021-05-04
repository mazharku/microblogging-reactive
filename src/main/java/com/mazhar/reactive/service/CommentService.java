/**
 * 
 */
package com.mazhar.reactive.service;


import com.mazhar.reactive.exception.ResourceNotFound;
import com.mazhar.reactive.model.Comment;
import com.mazhar.reactive.model.dto.CommentDTO;
import com.mazhar.reactive.repository.CommentRepository;
import com.mazhar.reactive.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author mazhar
 *
 */
@Service
public class CommentService {

	private CommentRepository repository;
	private PostRepository postRepository;
	private ModelMapper modelMapper;

	public CommentService(CommentRepository repository,PostRepository postRepository, ModelMapper modelMapper) {
		this.repository = repository;
		this.postRepository = postRepository;
		this.modelMapper = modelMapper;
	}

	public Mono<Boolean> commentAPost(CommentDTO dto, UUID postId) throws ResourceNotFound {
		Comment comment = modelMapper.map(dto, Comment.class);
	    Mono.just(postId).
				map(repository::findById).
				handle((post, sink)->{
					if(!isValidPost(post)) {
						sink.error(new ResourceNotFound("jfjjfkf"));
					}
				});

	    comment.setPostId(postId);
		repository.save(comment);
		return Mono.just(true);
	}

	private boolean isValidPost(Mono<Comment> post) {
		return true;
	}

	public Flux<Comment> getAllComments(UUID postId) {
		return repository.getCommentsByPost(postId);
	}

}
