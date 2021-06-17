package com.mazhar.reactive.service;

import com.mazhar.reactive.model.BlogPost;
import com.mazhar.reactive.model.dto.PostDTO;
import com.mazhar.reactive.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class PostService {

    private PostRepository repository;
    private ModelMapper modelMapper;
    private BlogMapper postMapper;

    @Autowired
    PostService(PostRepository repository, ModelMapper modelMapper, BlogMapper postMapper){
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.postMapper = postMapper;
    }

    public Flux<PostDTO> getPosts() {
        return repository.findAll().flatMap(e -> Mono.just(postMapper.postToPostDto(e)));
    }

    public Mono<?> getPostById(UUID id) {
            return repository.findById(id).flatMap(e -> Mono.just(modelMapper.map(e, PostDTO.class)));
    }

    public Mono<BlogPost> createPost(BlogPost post){
        return repository.save(post);
    }

    public Flux<PostDTO> getPostsOfUser(UUID userId) {
        return repository.getPostByUser(userId).flatMap(e -> Mono.just(modelMapper.map(e, PostDTO.class)));
    }
    public Mono<Void> deletePost(UUID postId) {
       return repository.deleteById(postId);
    }

}
